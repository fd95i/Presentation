package vistas;

import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.io.File;

import javax.swing.*;

import controladoresFTP.Ftp;

public class FTPView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JFrame mainFrame;

	private Ftp ftp;

	private FileDialog fileDialog = new FileDialog(mainFrame);

	private JLabel lblArchivoSel = new JLabel("Directorio seleccionado: actual");
	private JLabel lblCliArchivoSel = new JLabel("Archivo seleccionado:");

	private JButton btnAbrir = new JButton("Examinar..");
	private JButton btnSubir = new JButton("Subir");
	private JButton btnDescargar = new JButton("Descargar");
	private JButton btnBorrar = new JButton("Eliminar");

	private GridBagConstraints leftConstraints;
	private GridBagConstraints rightConstraints;

	private List archivosCliente = new List(22);
	private List archivosServer = new List(22);

	private String selectedDestination = "";
	private String selectedRelativePath = ".";
	private String selectedFileDirectory = "";
	private String selectedFileName;

	public FTPView(ConexionSimple window, JFrame mainFrame, Ftp ftp) {
		this.ftp = ftp;
		this.mainFrame = mainFrame;
		this.setLayout(new GridLayout(1, 2));
		this.createAllComponents();
		this.setListeners();
		this.add(this.initLeftPanel());
		this.add(this.initRightPanel());
		this.setVisible(true);
	}

	private void createAllComponents(){
		leftConstraints = new GridBagConstraints();
		rightConstraints = new GridBagConstraints();
	}

	private JPanel initLeftPanel(){
		JPanel leftPanel = new JPanel();
		GridBagLayout leftPanelLayout = new GridBagLayout();
		leftPanel.setLayout(leftPanelLayout);

		leftConstraints.gridx = 0;
		leftConstraints.gridy = 0;
		leftConstraints.gridwidth = 1;
		leftConstraints.weightx = .5;
		leftConstraints.fill = GridBagConstraints.HORIZONTAL;
		leftPanel.add(btnAbrir, leftConstraints);

		leftConstraints.gridx = 1;
		leftConstraints.gridy = 0;
		leftPanel.add(btnSubir, leftConstraints);

		leftConstraints.gridx = 0;
		leftConstraints.gridy = 1;
		leftConstraints.gridwidth = 2;
		leftPanel.add(lblCliArchivoSel, leftConstraints);

		leftConstraints.gridx = 0;
		leftConstraints.gridy = 2;
		leftConstraints.gridwidth = 2;
		refreshCliList("");
		leftPanel.add(archivosCliente, leftConstraints);

		return leftPanel;
	}

	private JPanel initRightPanel(){
		JPanel rightPanel = new JPanel();
		GridBagLayout rightPanelLayout = new GridBagLayout();
		rightPanel.setLayout(rightPanelLayout);

		rightConstraints.gridx = 0;
		rightConstraints.gridy = 0;
		rightConstraints.gridwidth = 1;
		rightConstraints.weightx = 1;
		rightConstraints.fill = GridBagConstraints.HORIZONTAL;

		rightPanel.add(btnDescargar, rightConstraints);

		rightConstraints.gridx = 1;
		rightConstraints.gridy = 0;
		rightConstraints.fill = GridBagConstraints.HORIZONTAL;

		rightPanel.add(btnBorrar, rightConstraints);

		rightConstraints.gridx = 0;
		rightConstraints.gridy = 1;
		rightConstraints.gridwidth = 2;
		rightPanel.add(lblArchivoSel, rightConstraints);

		String[] ftpListing = ftp.getListing();
		for (String ftp : ftpListing) {
			archivosServer.add(ftp);
		}

		rightConstraints.gridx = 0;
		rightConstraints.gridy = 2;
		rightConstraints.gridwidth = 2;
		rightPanel.add(archivosServer, rightConstraints);

		return rightPanel;
	}

	private void setListeners(){
		btnAbrir.addActionListener(e -> {
			fileDialog.setVisible(true);

			if (!(fileDialog.getFile().isEmpty()) && !(fileDialog.getDirectory().isEmpty())) {
				selectedFileDirectory = fileDialog.getDirectory();
				selectedFileName = fileDialog.getFile();

				if (!(selectedFileName.isEmpty()) && !(selectedFileDirectory.isEmpty())) {
					lblCliArchivoSel.setText("Archivo Seleccionado:" + selectedFileName);
					refreshCliList(selectedFileDirectory);
				}
			}
		});

		btnSubir.addActionListener(e -> {
			if (selectedFileName.isEmpty()) {
				lblCliArchivoSel.setText("Debes seleccionar un archivo primero.");
			}

			if (ftp.upload(selectedFileDirectory, selectedFileName)) {
				lblArchivoSel.setText("Archivo subido exitosamente!");
				refreshList(selectedDestination);
			} else {
				lblArchivoSel.setText("Carga fallida");
			}
		});

		archivosCliente.addActionListener(e -> {
			String tmpRelativePath = selectedRelativePath + "/" + archivosCliente.getSelectedItem();
			File testFile = new File(tmpRelativePath);

			if (testFile.isDirectory()) {
				selectedRelativePath += "/" + archivosCliente.getSelectedItem();
				refreshCliList(selectedRelativePath);
				selectedRelativePath = testFile.getAbsolutePath();
			} else {
				// set selected file
				selectedFileName = archivosCliente.getSelectedItem();
				selectedFileDirectory = "/" + selectedRelativePath;
				File newFile = new File(selectedFileDirectory);
				selectedFileDirectory = newFile.getAbsolutePath() + '/';
				System.out.println(newFile.getAbsolutePath() + '/' + selectedFileName);
				lblCliArchivoSel.setText("Archivo Seleccionado:" + archivosCliente.getSelectedItem());
			}
		});

		btnDescargar.addActionListener(e -> {
			if (selectedDestination.isEmpty()) {
				lblArchivoSel.setText("Debes seleccionar un archivo para descargar.");
			}

			if (selectedFileDirectory.isEmpty()) {
				lblArchivoSel.setText("Debes seleccionar un directorio en donde descargar el archivo");
			}

			if (ftp.download(selectedFileDirectory + "/" + selectedDestination, selectedDestination)) {
				lblArchivoSel.setText("Descarga exitosa!");
				refreshCliList(selectedFileDirectory);
			} else {
				lblArchivoSel.setText("Descarga fallida.");
			}
		});

		btnBorrar.addActionListener(e ->  {
			if (selectedDestination.isEmpty()) {
				lblArchivoSel.setText("Debes seleccionar un archivo para eliminar.");
			}

			System.out.println(selectedDestination);

			if (ftp.deleteFile(selectedDestination)) {
				lblArchivoSel.setText("Se ha eliminado el archivo!");
				refreshList(selectedDestination);
			} else {
				lblArchivoSel.setText("Fallo en la eliminación.");
			}
		});

		archivosServer.addActionListener(e -> refreshList(archivosServer.getSelectedItem()));
	}

	private void refreshList(String newDirectory) {
		archivosServer.removeAll();
		selectedDestination = newDirectory;
		lblArchivoSel.setText("Directorio seleccionado: " + selectedDestination);
		ftp.changeWorkingDirectory(newDirectory);
		String[] ftpListing = ftp.getListing();
		for (String ftp : ftpListing) {
			archivosServer.add(ftp);
		}
	}

	private void refreshCliList(String currentClientDirectory) {
		archivosCliente.removeAll();

		File folder = new File(currentClientDirectory);

		folder = new File(folder.getAbsolutePath());
		File[] listaArchivos = folder.listFiles();

		archivosCliente.add(".");
		archivosCliente.add("..");

		for (File archivo : listaArchivos) {
			try{
				archivosCliente.add(archivo.getName());
			} catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null,"No se encuentran archivos");
			}
		}

	}

}


package becompproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;


import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;

public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    
    @FXML
    private AnchorPane main_menu;
    @FXML
    private AnchorPane backup_window;
    @FXML
    private AnchorPane backup_window_normal_1;
    
    @FXML
    private JFXButton backup_normal2;
    @FXML
    private JFXTextField selectedFilePath;
    
    File ChosenFile;
    String filePath;
    String compression_directory_filepath;
    String backup_directory_filepath;
    String encryption_filepath;
    
    @FXML
    private JFXComboBox<String> driveList;
    ObservableList<String> driveListOptions = FXCollections.observableArrayList();
    
    @FXML
    private JFXComboBox<String> drivelist_directory_backup;
    ObservableList<String> driveListOptions_directory = FXCollections.observableArrayList();
    
    @FXML
    private JFXComboBox<String> drivelist_directory_backup_encryption;
    ObservableList<String> driveListOptions_directory_encryption = FXCollections.observableArrayList();
    
    String[] letters;
    File[] drives;
    boolean[] isDrive;
    
    String[] letters_directory_backup;
    File[] drives_directory_backup;
    boolean[] isDrive_directory_backup;
    
    String[] letters_directory_backup_encryption;
    File[] drives_directory_backup_encryption;
    boolean[] isDrive_directory_backup_encryption;
    
    @FXML
    private AnchorPane main_anchor;
    @FXML
    private JFXButton disk_encryption1;
    @FXML
    private JFXButton ids;
    @FXML
    private JFXButton ips;
    @FXML
    private JFXButton backup_normal_1;
    @FXML
    private JFXButton backup_encryption1;
    
    @FXML
    private AnchorPane backup_window_normal_2;
    @FXML
    private JFXButton Backup1;
    @FXML
    private AnchorPane compression_window_1;
    @FXML
    private JFXButton backup_directory_normal;
    @FXML
    private TitledPane normal_backup_button;
    @FXML
    private AnchorPane directory_backup;
    @FXML
    private JFXButton compress_directory_1;
    @FXML
    private AnchorPane compress_directory_window;
    @FXML
    private JFXButton choose_directory;
    private JFXButton compress_file_1;
    @FXML
    private JFXButton choose_directory_1;
    @FXML
    private AnchorPane disk_encryption_window;
    @FXML
    private AnchorPane ids_window;
    @FXML
    private JFXButton back_button_data_compression_window;
    @FXML
    private JFXButton back_button_directory_compression;
    @FXML
    private JFXButton back_backup_window;
    @FXML
    private JFXButton back_backup_file_normal;
    @FXML
    private JFXButton back_normal_backup_window;
    @FXML
    private JFXButton back_directory_backup_normal;
    @FXML
    private AnchorPane ips_window;
    @FXML
    private JFXTextField directory_compression_filepath;
    @FXML
    private JFXButton compress_directory_2;
    @FXML
    private JFXTextField directory_backup_filepath_1;
    @FXML
    private TitledPane backup_title;
    @FXML
    private AnchorPane backup_with_encryption_window;
    @FXML
    private JFXButton back_backup_with_encryption_button;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        ChosenFile = null;
//        filePath =null;
        //
        
        backup_window.setDisable(true);
        backup_window.setOpacity(0);
        
        backup_window_normal_1.setDisable(true);
        backup_window_normal_1.setOpacity(0);
        
        compression_window_1.setDisable(true);
        compression_window_1.setOpacity(0);
        
        disk_encryption_window.setDisable(true);
        disk_encryption_window.setOpacity(0);
        
        ips_window.setDisable(true);
        ips_window.setOpacity(0);
        
        ids_window.setDisable(true);
        ids_window.setOpacity(0);
        
        letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
        drives = new File[letters.length];
        isDrive = new boolean[letters.length];
        for(int i= 0; i < isDrive.length ; i++){
            drives[i] = new File(letters[i]+":");
            isDrive[i] = drives[i].canRead();
        }
        
        
        //for directory backup
        letters_directory_backup = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
        drives_directory_backup = new File[letters_directory_backup.length];
        isDrive_directory_backup = new boolean[letters_directory_backup.length];
        for(int i= 0; i < isDrive_directory_backup.length ; i++){
            drives_directory_backup[i] = new File(letters_directory_backup[i]+":");
            isDrive_directory_backup[i] = drives_directory_backup[i].canRead();
        }
        
        
        //for directory backup WITH ENCRYPTION
        letters_directory_backup_encryption = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
        drives_directory_backup_encryption = new File[letters_directory_backup_encryption.length];
        isDrive_directory_backup_encryption = new boolean[letters_directory_backup_encryption.length];
        for(int i= 0; i < isDrive_directory_backup_encryption.length ; i++){
            drives_directory_backup_encryption[i] = new File(letters_directory_backup_encryption[i]+":");
            isDrive_directory_backup_encryption[i] = drives_directory_backup_encryption[i].canRead();
        }
    }    

    
   //--------------------------------------------------------------------------------------------------------------------------//
   //----------------------------------------!!!!!!!!!!!!!!!!!!----------------------------------------------------------------//
   //----------------------------------------BACKUP MODULE---------------------------------------------------------------------//
    
    //-----------------------------------------FILE BACKUP---------------------------------------------------------------------//
    
    @FXML
    private void Backup1(ActionEvent event) {
       
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        backup_with_encryption_window.setDisable(true);
        backup_with_encryption_window.setOpacity(0);
        
        backup_window_normal_1.setDisable(true);
        backup_window_normal_1.setOpacity(0);
        
        backup_window.setDisable(false);
        backup_window.setOpacity(1);
        
        directory_backup.setDisable(true);
        directory_backup.setOpacity(0);
        
        backup_window_normal_2.setDisable(true);
        backup_window_normal_2.setOpacity(0);
    }
    
    @FXML
    private void Backup_normal_1(ActionEvent event) {
        
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        backup_window.setDisable(true);
        backup_window.setOpacity(0);
        
        backup_window_normal_1.setDisable(false);
        backup_window_normal_1.setOpacity(1);
        
    }
    
    
    @FXML
    private void dataBackupAction(ActionEvent event) {
        
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        back_normal_backup_window.setDisable(true);
        back_normal_backup_window.setOpacity(0);
        
        backup_window.setDisable(true);
        backup_window.setOpacity(0);
        
        backup_normal2.setDisable(true);
        backup_normal2.setOpacity(0);
        
        
        
        backup_window_normal_2.setDisable(false);
        backup_window_normal_2.setOpacity(1);
        
        backup_directory_normal.setDisable(true);
        backup_directory_normal.setOpacity(0);
        
        //dataBackBtn.setOpacity(0);
        //dataBackBtn.setDisable(true);
    }

    @FXML
    private void browseFileAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Browse Files");
        ChosenFile = fileChooser.showOpenDialog(null);
        if (ChosenFile != null) {
            selectedFilePath.setText(ChosenFile.getAbsolutePath());
            System.out.println(ChosenFile.getAbsolutePath());
           filePath = ChosenFile.getAbsolutePath();
           System.out.println(ChosenFile.getAbsolutePath());
        }
        

    }

        
    void detectDrives(){
        
        for ( int i = 0; i < letters.length; ++i )
            {
            boolean pluggedIn = drives[i].canRead();

            // if the state has changed output a message
            if ( pluggedIn != isDrive[i] )
                {
                if ( pluggedIn )
                {
                    System.out.println("Drive "+letters[i]+" has been plugged in");
                    driveListOptions.add(letters[i]+":");
                    
                }
//                else
//                    System.out.println("Drive "+letters[i]+" has been unplugged");

                isDrive[i] = pluggedIn;
                }
            }
        if(driveListOptions.equals(null)){
           JOptionPane.showMessageDialog(null,  "No Drives Detected :(","Error!", JOptionPane.INFORMATION_MESSAGE);
           return;
        }
        driveList.setItems(driveListOptions);
    }

    @FXML
    private void copyToDriveAction(ActionEvent event) {
        try{
            int length;
            InputStream is;
            OutputStream os;
            System.out.println(ChosenFile.getAbsoluteFile());
            System.out.println(filePath);
            System.out.println(ChosenFile.getAbsolutePath());
            is = new FileInputStream(ChosenFile.getAbsolutePath());
          //  System.out.println(driveList.getValue());
          String filepath = driveList.getValue();
          
           //System.out.println(filepath+"\\print\\i_am_here.txt");
            os = new FileOutputStream(filepath+"\\print\\"+ChosenFile.getName());
           // System.out.println(filePath);
            byte [] buffer = new byte[1024];

            while((length = is.read(buffer))>0)
               os.write(buffer,0,length);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("FILE BACKUP");
            alert.setHeaderText(null);
            alert.setContentText("FILE BACKED UP SUCESSFULLY!!!!!");
        
            alert.showAndWait();
        }

            catch(Exception e){}
    }

    
    @FXML
    private void detectDrivesAction(ActionEvent event) {
        detectDrives();
    }
    
    //-----------------------------------------END OF FILE BACKUP--------------------------------------------------------------//
    
    
    
    //-----------------------------------------DIRECTORY BACKUP----------------------------------------------------------------//
    
    @FXML
    private void backup_directory_normal(ActionEvent event) {
        normal_backup_button.setDisable(true);
        normal_backup_button.setOpacity(0);
        
        backup_directory_normal.setDisable(true);
        backup_directory_normal.setOpacity(0);
        
        backup_normal2.setDisable(true);
        backup_normal2.setOpacity(0);
        
        directory_backup.setDisable(false);
        directory_backup.setOpacity(1);
        
        back_normal_backup_window.setDisable(true);
        back_normal_backup_window.setOpacity(0);
    }
    
    
    
    @FXML
    private void choose_directory_1(ActionEvent event){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("CHOOSE DIRECTORY");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
         //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
         System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
          } else {
                  System.out.println("No Selection ");
                 }
         backup_directory_filepath = chooser.getSelectedFile().getAbsolutePath();
         directory_backup_filepath_1.setText(backup_directory_filepath);
         
         
        
    }
    
    @FXML
    private void detect_drives_directory_backup(ActionEvent event) {
        
        
        for ( int i = 0; i < letters_directory_backup.length; ++i )
            {
            boolean pluggedIn = drives_directory_backup[i].canRead();

            // if the state has changed output a message
            if ( pluggedIn != isDrive_directory_backup[i] )
                {
                if ( pluggedIn )
                {
                    System.out.println("Drive "+letters_directory_backup[i]+" has been plugged in");
                    driveListOptions_directory.add(letters_directory_backup[i]+":");
                    
                }
//                else
//                    System.out.println("Drive "+letters[i]+" has been unplugged");

                isDrive_directory_backup[i] = pluggedIn;
                }
            }
        if(driveListOptions_directory.equals(null)){
           JOptionPane.showMessageDialog(null,  "No Drives Detected :(","Error!", JOptionPane.INFORMATION_MESSAGE);
           return;
        }
        drivelist_directory_backup.setItems(driveListOptions_directory);
    }
    
    @FXML
    private void directory_backup_normal(ActionEvent event)throws IOException {
        
        String filepath_directory_backup = drivelist_directory_backup.getValue();
        //System.out.println(filepath_directory_backup);

           // modifications of paths should be dome here 
           File srcDir = new File(backup_directory_filepath);
           File destDir = new File(filepath_directory_backup);
           //System.out.println(srcDir.getName());
           String folder_name = srcDir.getName();
           
           
           File destDir_n = new File(filepath_directory_backup+"\\"+folder_name);
    
           // attempt to create the directory here
           boolean successful = destDir_n.mkdir();
           if (successful)
           {
            // creating the directory succeeded
            System.out.println("directory was created successfully");
           }
           else
           {
            // creating the directory failed
            System.out.println("failed trying to create the directory");
           }

           
           // Make sure srcDir exists
           if (!srcDir.exists())
           {
            System.out.println("Directory does not exist.");
           }
           else
           {
            FileDemo fileDemo = new FileDemo();
            fileDemo.copydir(srcDir, destDir_n);
            
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("DIRECTORY BACKUP");
            alert.setHeaderText(null);
            alert.setContentText("DIRECTORY BACKED UP TO "+filepath_directory_backup+" SUCCESSFULLY!!!!!");
        
            alert.showAndWait();
            //System.out.println("Copied successfully.");
           }
        
        
    }
    
   //------------------------------------------END OF DIRECTORY BACKUP---------------------------------------------------------//
    
    
   //------------------------------------------BACKUP WITH ENCRYPTION----------------------------------------------------------//
    
    @FXML
    private void backup_encryption(ActionEvent event) {
        
      //(new JFilechooser_dir_1()).launch();  
        
        back_backup_window.setDisable(true);
        back_backup_window.setOpacity(0);
        
        backup_title.setDisable(true);
        backup_title.setOpacity(0);
        
        backup_normal_1.setDisable(true);
        backup_normal_1.setOpacity(0);
        
        backup_encryption1.setDisable(true);
        backup_encryption1.setOpacity(0);
        
        backup_with_encryption_window.setDisable(false);
        backup_with_encryption_window.setOpacity(1);
    }
    
    @FXML
    private void encrypt_before_backup(ActionEvent event) {
        
        (new JFilechooser_dir_1()).launch(); 
    }
    
    @FXML
    private void detect_drives_backup_encryption(ActionEvent event) {
       
        for ( int i = 0; i < letters_directory_backup_encryption.length; ++i )
            {
            boolean pluggedIn = drives_directory_backup_encryption[i].canRead();

            // if the state has changed output a message
            if ( pluggedIn != isDrive_directory_backup_encryption[i] )
                {
                if ( pluggedIn )
                {
                    System.out.println("Drive "+letters_directory_backup_encryption[i]+" has been plugged in");
                    driveListOptions_directory_encryption.add(letters_directory_backup_encryption[i]+":");
                    System.out.println("hello");
                }
//                else
//                    System.out.println("Drive "+letters[i]+" has been unplugged");

                isDrive_directory_backup_encryption[i] = pluggedIn;
                System.out.println("hello");
                }
            }
        if(driveListOptions_directory_encryption.equals(null)){
           JOptionPane.showMessageDialog(null,  "No Drives Detected :(","Error!", JOptionPane.INFORMATION_MESSAGE);
           return;
        }
        drivelist_directory_backup_encryption.setItems(driveListOptions_directory_encryption);
    }

    
    @FXML
    private void backup_with_encryption_1(ActionEvent event) throws IOException{
        
        String filepath_directory_backup = drivelist_directory_backup_encryption.getValue();
        //System.out.println(filepath_directory_backup);

           // modifications of paths should be dome here 
           File srcDir = new File(encryption_filepath);
           //File destDir = new File(filepath_directory_backup);
           //System.out.println(srcDir.getName());
           String folder_name = srcDir.getName();
           
           
           File destDir_n = new File(filepath_directory_backup+"\\"+folder_name);
    
           // attempt to create the directory here
           boolean successful = destDir_n.mkdir();
           if (successful)
           {
            // creating the directory succeeded
            System.out.println("directory was created successfully");
           }
           else
           {
            // creating the directory failed
            System.out.println("failed trying to create the directory");
           }

           
           // Make sure srcDir exists
           if (!srcDir.exists())
           {
            System.out.println("Directory does not exist.");
           }
           else
           {
            FileDemo fileDemo = new FileDemo();
            fileDemo.copydir(srcDir, destDir_n);
            
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("DIRECTORY BACKUP");
            alert.setHeaderText(null);
            alert.setContentText("DIRECTORY ENCRYPTED AND BACKED UP TO "+filepath_directory_backup+" SUCCESSFULLY!!!!!");
        
            alert.showAndWait();
            //System.out.println("Copied successfully.");
           }
        
    }

    
   //-------------------------------------------END OF BACKUP WITH ENCRYPTION--------------------------------------------------//
    
    
    
   //---------------------------------------------END OF BACKUP----------------------------------------------------------------// 
    
    
   //--------------------------------------------------------------------------------------------------------------------------//
   //----------------------------------------!!!!!!!!!!!!!!!!!!----------------------------------------------------------------//
   //----------------------------------------DIRECTORY COMPRESSION-------------------------------------------------------------//
    
    
    @FXML
    private void choose_directory_compression(ActionEvent event) {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("CHOOSE DIRECTORY");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
           System.out.println("getSelectedFile() : " + chooser.getSelectedFile().getAbsolutePath());
             } else {
           System.out.println("No Selection ");
             }
            compression_directory_filepath = chooser.getSelectedFile().getAbsolutePath();
            directory_compression_filepath.setText(compression_directory_filepath);
            }
    
    @FXML
    private void compress_directory_2(ActionEvent event) {
        File inputDir = new File(compression_directory_filepath);
        File outputZipFile = new File(compression_directory_filepath+".zip");
        zipDirectory(inputDir, outputZipFile);
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("DIRECTORY COMPRESSION");
        alert.setHeaderText(null);
        alert.setContentText("DIRECTORY COMPRESSED SUCCESSFULLY!!!!!");
        
        alert.showAndWait();
        
    }
    
    
    @FXML
    private void data_compression_1(ActionEvent event) {
     
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        compress_directory_window.setDisable(true);
        compress_directory_window.setOpacity(0);
        
        compression_window_1.setDisable(false);
        compression_window_1.setOpacity(1);
        
    }

    // A method to Compress a directory.
    public void zipDirectory(File inputDir, File outputZipFile) {
        // Create parent directory for the output file.
        outputZipFile.getParentFile().mkdirs();
 
        String inputDirPath = inputDir.getAbsolutePath();
        byte[] buffer = new byte[1024];
 
        FileOutputStream fileOs = null;
        ZipOutputStream zipOs = null;
        try {
 
            List<File> allFiles = this.listChildFiles(inputDir);
 
            // Create ZipOutputStream object to write to the zip file
            fileOs = new FileOutputStream(outputZipFile);
            // 
            zipOs = new ZipOutputStream(fileOs);
            for (File file : allFiles) {
                String filePath = file.getAbsolutePath();
 
                System.out.println("Zipping " + filePath);
                
                String entryName = filePath.substring(inputDirPath.length() + 1);
 
                ZipEntry ze = new ZipEntry(entryName);
                // Put new entry into zip file.
                zipOs.putNextEntry(ze);
                // Read the file and write to ZipOutputStream.
                FileInputStream fileIs = new FileInputStream(filePath);
 
                int len;
                while ((len = fileIs.read(buffer)) > 0) {
                    zipOs.write(buffer, 0, len);
                }
                fileIs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuite(zipOs);
            closeQuite(fileOs);
        }
 
    }
 
    private void closeQuite(OutputStream out) {
        try {
            out.close();
        } catch (Exception e) {
        }
    }
 
    // This method returns the list of files,
    // including the children, grandchildren files of the input folder.
    private List<File> listChildFiles(File dir) throws IOException {
        List<File> allFiles = new ArrayList<File>();
 
        File[] childFiles = dir.listFiles();
        for (File file : childFiles) {
            if (file.isFile()) {
                allFiles.add(file);
            } else {
                List<File> files = this.listChildFiles(file);
                allFiles.addAll(files);
            }
        }
        return allFiles;
    } 
    @FXML
    private void compress_directory_1(ActionEvent event) {
        
        
        back_button_data_compression_window.setDisable(true);
        back_button_data_compression_window.setOpacity(0);
        
        compress_directory_1.setDisable(true);
        compress_directory_1.setOpacity(0);
        
        compress_directory_window.setDisable(false);
        compress_directory_window.setOpacity(1);
        
       /* back_button_directory_compression.setDisable(false);
        back_button_directory_compression.setOpacity(1);
        
        directory_compression_filepath.setDisable(false);
        directory_compression_filepath.setOpacity(1);
        
        compress_directory_2.setDisable(false);
        compress_directory_2.setOpacity(1);
        
        choose_directory.setDisable(false);
        choose_directory.setOpacity(1);*/
    }
    
   
//----------------------------------------END OF DIRECTORY COMPRESSION--------------------------------------------------------//
    
    
    //-------------------------------------------------------------------------------------------------------------------------//
   //----------------------------------------!!!!!!!!!!!!!!!!!!----------------------------------------------------------------//
   //----------------------------------------INTRUSION DETECTION SYSTEM--------------------------------------------------------//
    
    
    @FXML
    private void ids_button_1(ActionEvent event) {
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        ids_window.setDisable(false);
        ids_window.setOpacity(1);
        
    }
    
    //--------------------------------------SIMPLE SCAN-----------------------------------------------------------------------//
    
    @FXML
    private void simple_scan(ActionEvent event) throws Exception {
        
      int choice = 0;
      int flagdB=0,countdB=0,flagaS=0,countaS=0,flagaR=0,countaR=0;
      int iter=0;
      int TdB = 300;
      int TaS = 300;
      int TaR = 300;
      int count=0;
      Scanner sc = new Scanner(System.in);
      System.out.println("Welcome to IDS\n");

            ProcessBuilder builder = new ProcessBuilder(
              "cmd.exe", "/c", "tshark -i 1 -a duration:10 -w C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
              line = r.readLine();
              if (line == null) { break; }
              System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(1);

            ProcessBuilder builder1 = new ProcessBuilder(
                "cmd.exe", "/c", "capinfos C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap -x -y -z>C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacSys/analysis.txt");
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            while (true) {
                line1 = r1.readLine();
                if (line1 == null) { break; }
                System.out.println(line1);
            }
            TimeUnit.SECONDS.sleep(1);

            getByte g = new getByte();
            if(g.getDataByte()>TdB){
              flagdB=1;
              count++;
            }
            if(g.getAvgPkt()>TaS){
              flagaS=1;
              count++;
            }
            if(g.getAvgRt()>TaR){
              flagaR=1;
              count++;
            }

            System.out.println("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+")");
            System.out.println("Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")");
            System.out.println("Average packet rate:\t"+g.getAvgRt()+"("+flagaR+")");

            flagdB=0;
            flagaS=0;
            flagaR=0;

            if(count>=2)
            {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("INTRUSION DETECTION SYSTEM");
                alert.setHeaderText("Vulnerabilities assessed");
                alert.setContentText("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+") \n Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")\n Average packet rate:\t"+g.getAvgRt()+"("+flagaR+")");

                alert.showAndWait();
              //System.out.println("Your System is at potential risk!");
            }
            else
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("INTRUSION DETECTION SYSTEM");
                alert.setHeaderText("Vulnerabilities assessed");
                alert.setContentText("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+") \n Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")\n Average packet rate:\t"+g.getAvgRt()+"("+flagaR+") \n Your System has low risk!");

                alert.showAndWait();
              //System.out.println("Your System has low risk!");
            }
            count=0;
        
    }

    //--------------------------------------END OF SIMPLE SCAN------------------------------------------------------------------//
    
    
    //--------------------------------------RIGOROUS SCAN-----------------------------------------------------------------------//
    @FXML
    private void rigorous_scan(ActionEvent event) throws Exception{     
     
      int choice = 0;
      int flagdB=0,countdB=0,flagaS=0,countaS=0,flagaR=0,countaR=0;
      int iter=0;
      int TdB = 300;
      int TaS = 300;
      int TaR = 300;
      int count=0;
      Scanner sc = new Scanner(System.in);
      //System.out.println("Welcome to IDS\n");

            ProcessBuilder builder = new ProcessBuilder(
              "cmd.exe", "/c", "tshark -i 1 -a duration:10 C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap1/pc.pcap");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
              line = r.readLine();
              if (line == null) { break; }
              System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(1);

            ProcessBuilder builder1 = new ProcessBuilder(
                "cmd.exe", "/c", "capinfos C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap1/pc.pcap -x -y -z>C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacSys/analysis.txt");
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            while (true) {
                line1 = r1.readLine();
                if (line1 == null) { break; }
                System.out.println(line1);
            }
            TimeUnit.SECONDS.sleep(1);

            getbytes g = new getbytes();
            if(g.getDataByte()>TdB){
              flagdB=1;
              count++;
            }
            if(g.getAvgPkt()>TaS){
              flagaS=1;
              count++;
            }
            if(g.getAvgRt()>TaR){
              flagaR=1;
              count++;
            }

            System.out.println("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+")");
            System.out.println("Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")");
            System.out.println("Average packet rate:\t"+g.getAvgRt()+"("+flagaR+")");

            flagdB=0;
            flagaS=0;
            flagaR=0;

            if(count>=2)
              System.out.println("Your System is at potential risk!");
            else
              System.out.println("Your System has low risk!");
            count=0; 
  
}
    
    //--------------------------------------END OF RIGOROUS SCAN----------------------------------------------------------------//
    
    //--------------------------------------END OF INTRUSION DETECTION SYSTEM--------------------------------------------------//
    
    

   //-------------------------------------------------------------------------------------------------------------------------//
   //---------------------------------------!!!!!!!!!!!!!!!!!!----------------------------------------------------------------//
   //--------------------------------------INTRUSION PREVENTION SYSTEM--------------------------------------------------------//
    
    
    @FXML
    private void ips_button(ActionEvent event) {
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        ips_window.setDisable(false);
        ips_window.setOpacity(1);
    }
    
    //--------------------------------------SIMPLE SCAN-----------------------------------------------------------------------//
    
    @FXML
    private void simple_scan_ips(ActionEvent event) throws Exception{
        
        int choice = 0;
      int flagdB=0,countdB=0,flagaS=0,countaS=0,flagaR=0,countaR=0;
      int iter=0;
      int TdB = 300;
      int TaS = 300;
      int TaR = 300;
      int count=0;
      Scanner sc = new Scanner(System.in);
      System.out.println("Welcome to IPS\n");

            ProcessBuilder builder = new ProcessBuilder(
              "cmd.exe", "/c", "tshark -i 1 -a duration:10 -w C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
              line = r.readLine();
              if (line == null) { break; }
              System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(1);

            ProcessBuilder builder1 = new ProcessBuilder(
                "cmd.exe", "/c", "capinfos C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap -x -y -z>C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacSys/analysis.txt");
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            while (true) {
                line1 = r1.readLine();
                if (line1 == null) { break; }
                System.out.println(line1);
            }
            TimeUnit.SECONDS.sleep(1);

            getByte g = new getByte();
            if(g.getDataByte()>TdB){
              flagdB=1;
              count++;
            }
            if(g.getAvgPkt()>TaS){
              flagaS=1;
              count++;
            }
            if(g.getAvgRt()>TaR){
              flagaR=1;
              count++;
            }

            System.out.println("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+")");
            System.out.println("Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")");
            System.out.println("Average packet rate:\t"+g.getAvgRt()+"("+flagaR+")");

            flagdB=0;
            flagaS=0;
            flagaR=0;

            if(count>=2)
            {
              System.out.println("Your System is at potential risk!");
              System.out.println("Running IPS System");
              ProcessBuilder builder5 = new ProcessBuilder(
                "cmd.exe", "/c", "netsh winsock reset");
              builder5.redirectErrorStream(true);
              Process p5 = builder5.start();
              BufferedReader r5 = new BufferedReader(new InputStreamReader(p5.getInputStream()));
              String line5;
              while (true) {
                line5 = r5.readLine();
                if (line5 == null) { break; }
                System.out.println(line5);
            }
              //System.out.println("Your System is at potential risk!");
            }
            else
              System.out.println("Your System has low risk!");
            count=0;
    }

    //--------------------------------------END OF SIMPLE SCAN------------------------------------------------------------------//
    
    
    //--------------------------------------RIGOROUS SCAN-----------------------------------------------------------------------//
    
    @FXML
    private void rigorous_scan_ips(ActionEvent event) throws Exception{
        
        int choice = 0;
      int flagdB=0,countdB=0,flagaS=0,countaS=0,flagaR=0,countaR=0;
      int iter=0;
      int TdB = 300;
      int TaS = 300;
      int TaR = 300;
      int count=0;
      Scanner sc = new Scanner(System.in);
      System.out.println("Welcome to IPS\n");

            ProcessBuilder builder = new ProcessBuilder(
              "cmd.exe", "/c", "tshark -i 1 -a duration:10 C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
              line = r.readLine();
              if (line == null) { break; }
              System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(1);

            ProcessBuilder builder1 = new ProcessBuilder(
                "cmd.exe", "/c", "capinfos C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacCap/pc.pcap -x -y -z>C:/Users/Public/Documents/BeCompProject_v7/src/becompproject/pacSys/analysis.txt");
            builder1.redirectErrorStream(true);
            Process p1 = builder1.start();
            BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
            String line1;
            while (true) {
                line1 = r1.readLine();
                if (line1 == null) { break; }
                System.out.println(line1);
            }
            TimeUnit.SECONDS.sleep(1);

            getbytes g = new getbytes();
            if(g.getDataByte()>TdB){
              flagdB=1;
              count++;
            }
            if(g.getAvgPkt()>TaS){
              flagaS=1;
              count++;
            }
            if(g.getAvgRt()>TaR){
              flagaR=1;
              count++;
            }

            System.out.println("Data byte rate:\t\t"+g.getDataByte()+"("+flagdB+")");
            System.out.println("Average packet size:\t"+g.getAvgPkt()+"("+flagaS+")");
            System.out.println("Average packet rate:\t"+g.getAvgRt()+"("+flagaR+")");

            flagdB=0;
            flagaS=0;
            flagaR=0;

            if(count>=2)
            {
                System.out.println("Your System is at potential risk!");
              System.out.println("Running IPS System");
              ProcessBuilder builder5 = new ProcessBuilder(
                "cmd.exe", "/c", "netsh winsock reset");
              builder5.redirectErrorStream(true);
              Process p5 = builder5.start();
              BufferedReader r5 = new BufferedReader(new InputStreamReader(p5.getInputStream()));
              String line5;
              while (true) {
                line5 = r5.readLine();
                if (line5 == null) { break; }
                System.out.println(line5);
            }
            }
              //System.out.println("Your System is at potential risk!");
            else
              System.out.println("Your System has low risk!");
            count=0; 
    }

    //--------------------------------------END OF RIGOROUS SCAN----------------------------------------------------------------//
    
    //--------------------------------------END OF INTRUSION PREVENTION SYSTEM--------------------------------------------------//
    
    
    
    //--------------------------------------------------------------------------------------------------------------------------//
    
    @FXML
    private void disk_encryption_button(ActionEvent event) {
        main_menu.setDisable(true);
        main_menu.setOpacity(0);
        
        disk_encryption_window.setDisable(false);
        disk_encryption_window.setOpacity(1);
       
    }

    //---------------------------------------!!!!!!!!!!!!!!!!!!-----------------------------------------------------------------//
    //--------------------------------------ENCRYPTION--------------------------------------------------------------------------//

       
    class Crypto {

    void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
	 try {
	       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
	       Cipher cipher = Cipher.getInstance("AES");
	       cipher.init(cipherMode, secretKey);

	       FileInputStream inputStream = new FileInputStream(inputFile);
	       byte[] inputBytes = new byte[(int) inputFile.length()];
	       inputStream.read(inputBytes);

	       byte[] outputBytes = cipher.doFinal(inputBytes);

	       FileOutputStream outputStream = new FileOutputStream(outputFile);
	       outputStream.write(outputBytes);

	       inputStream.close();
	       outputStream.close();

	    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
                     | InvalidKeyException | BadPaddingException
	             | IllegalBlockSizeException | IOException e) {
		e.printStackTrace();
            }
     }
	
    public  void encrypt(String path) {
	String key = "This is a secret";
	File inputFile = new File(path);
	File encryptedFile = new File(path+".encrypted");
	//File decryptedFile = new File(path.replace(".encrypted",""));
		
	try {
	     fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
	     //Crypto.fileProcessor(Cipher.DECRYPT_MODE,key,inputFile,decryptedFile);
	     System.out.println("Success");
	} catch (Exception ex) {
	     System.out.println(ex.getMessage());
             ex.printStackTrace();
	 	}
	}	
}

class Walk{
	public void walk(String path)
	{
		File root = new File( path );
		File[] list = root.listFiles();
        if (list == null) return;
        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                System.out.println( "Encrypting file:" + f.getAbsoluteFile() );
                try
                {
                	(new Crypto()).encrypt(f.getAbsolutePath());
                	if (f.delete()) {
                		// do nothing
                	}
                	else {
                		//do nothing
                	}
                }
                catch (Exception e) {
                	e.printStackTrace();
                }
            }
        }
        
        //ALERT CODE
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("ENCRYPTION MODULE");
        alert.setHeaderText(null);
        alert.setContentText("DIRECTORY ENCRYPTED SUCCESSFULLY!!!!!");
        
        alert.showAndWait();
        
	}
}

class JFilechooser_dir_1 {
    
    public void launch() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("CHOOSE DIRECTORY TO ENCRYPT");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
      //System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
    	(new Walk()).walk((chooser.getSelectedFile()).getAbsolutePath());
        
        encryption_filepath = chooser.getSelectedFile().getAbsolutePath();
    } else {
      System.out.println("No Selection ");
    }
  }
    
}
    @FXML
    private void encrypt_1(ActionEvent event) {
        
        (new JFilechooser_dir_1()).launch();
        
    }

    
    //-------------------------------------------------END OF ENCRYPTION-----------------------------------------------------//
    
    
    //-----------------------------------------------------------------------------------------------------------------------//
    //---------------------------------------!!!!!!!!!!!!!!!!!!--------------------------------------------------------------//
    //-----------------------------------------------------DECRYPTION--------------------------------------------------------//
    
    
    class Crypto_1 {

    void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
	 try {
	       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
	       Cipher cipher = Cipher.getInstance("AES");
	       cipher.init(cipherMode, secretKey);

	       FileInputStream inputStream = new FileInputStream(inputFile);
	       byte[] inputBytes = new byte[(int) inputFile.length()];
	       inputStream.read(inputBytes);

	       byte[] outputBytes = cipher.doFinal(inputBytes);

	       FileOutputStream outputStream = new FileOutputStream(outputFile);
	       outputStream.write(outputBytes);

	       inputStream.close();
	       outputStream.close();

	    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
                     | InvalidKeyException | BadPaddingException
	             | IllegalBlockSizeException | IOException e) {
		e.printStackTrace();
            }
     }
	
    public  void encrypt(String path) {
	String key = "This is a secret";
	File inputFile = new File(path);
	//File encryptedFile = new File(path+".encrypted");
	File decryptedFile = new File(path.replace(".encrypted",""));
		
	try {
	     //Crypto.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
	     fileProcessor(Cipher.DECRYPT_MODE,key,inputFile,decryptedFile);
	     System.out.println("Success");
	} catch (Exception ex) {
	     System.out.println(ex.getMessage());
             ex.printStackTrace();
	 	}
	}	
}

class Walk_1{
	public void walk(String path)
	{
		File root = new File( path );
		//AESFileDecryption aes=new AESFileDecryption();
        File[] list = root.listFiles();
        if (list == null) return;
        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
                System.out.println( "Decrypting file:" + f.getAbsoluteFile() );
                try
                {
                	(new Crypto_1()).encrypt(f.getAbsolutePath());
                	if (f.delete()) {
                		// do nothing
                	}
                	else {
                		//do nothing
                	}
                }
                catch (Exception e) {
                	e.printStackTrace();
                }
            }
        }
        
        //ALERT CODE
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("DECRYPTION MODULE");
        alert.setHeaderText(null);
        alert.setContentText("DIRECTORY DECRYPTED SUCCESSFULLY!!!!!");
        
        alert.showAndWait();
        
	}
}

class JFilechooser_dir_1_1 {
    
    public void launch() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("CHOOSE DIRECTORY TO DECRYPT");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
      //System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
    	(new Walk_1()).walk((chooser.getSelectedFile()).getAbsolutePath());	
    } else {
      System.out.println("No Selection ");
    }
  }
    
}
    @FXML
    private void decrypt_1(ActionEvent event) {
        (new JFilechooser_dir_1_1()).launch();
        
    }
    
    
    //------------------------------------------------END OF DECRYPTION-----------------------------------------------------//
    
    
    
    //----------------------------------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------------------------------//
    //!!!!!-----------------------------------------------------------------------------------------------------------!!!!!!//
    
    //-------------------------------------BACK BUTTON FUNCTIONS------------------------------------------------------------//
    
    
    @FXML
    private void back_data_compression_window(ActionEvent event) {
        
        compression_window_1.setDisable(true);
        compression_window_1.setOpacity(0);
        
        main_menu.setDisable(false);
        main_menu.setOpacity(1);
    }

    @FXML
    private void back_directory_compression(ActionEvent event) {
        compress_directory_window.setDisable(true);
        compress_directory_window.setOpacity(0);
        
        compression_window_1.setDisable(false);
        compression_window_1.setOpacity(1);
        
        compress_directory_1.setDisable(false);
        compress_directory_1.setOpacity(1);
        
        back_button_data_compression_window.setDisable(false);
        back_button_data_compression_window.setOpacity(1);
    }

    @FXML
    private void back_backup_window(ActionEvent event) {
        
        backup_window.setDisable(true);
        backup_window.setOpacity(0);
        
        main_menu.setDisable(false);
        main_menu.setOpacity(1); 
    }

    @FXML
    private void back_normal_backup_window(ActionEvent event) {
        
        backup_window_normal_1.setDisable(true);
        backup_window_normal_1.setOpacity(0);
        
        backup_window.setDisable(false);
        backup_window.setOpacity(1);
    }

    @FXML
    private void back_backup_file_normal(ActionEvent event) {
        
        backup_window_normal_2.setDisable(true);
        backup_window_normal_2.setOpacity(0);
        
        backup_window_normal_1.setDisable(false);
        backup_window_normal_1.setOpacity(1);
        
        back_normal_backup_window.setDisable(false);
        back_normal_backup_window.setOpacity(1);
        
        backup_directory_normal.setDisable(false);
        backup_directory_normal.setOpacity(1);
        
        backup_normal2.setDisable(false);
        backup_normal2.setOpacity(1);
    }

    @FXML
    private void back_directory_backup_normal(ActionEvent event) {
        
        directory_backup.setDisable(true);
        directory_backup.setOpacity(0);
        
        backup_window_normal_1.setDisable(false);
        backup_window_normal_1.setOpacity(1);
        
        normal_backup_button.setDisable(false);
        normal_backup_button.setOpacity(1);
        
        backup_directory_normal.setDisable(false);
        backup_directory_normal.setOpacity(1);
        
        backup_normal2.setDisable(false);
        backup_normal2.setOpacity(1);
        
        back_normal_backup_window.setDisable(false);
        back_normal_backup_window.setOpacity(1);
    }

    @FXML
    private void back_backup_with_encryption(ActionEvent event) {
        backup_with_encryption_window.setDisable(true);
        backup_with_encryption_window.setOpacity(0);
        
        back_backup_window.setDisable(false);
        back_backup_window.setOpacity(1);
        
        backup_title.setDisable(false);
        backup_title.setOpacity(1);
        
        backup_normal_1.setDisable(false);
        backup_normal_1.setOpacity(1);
        
        backup_encryption1.setDisable(false);
        backup_encryption1.setOpacity(1);
        
    }

    @FXML
    private void back_data_encryption(ActionEvent event) {
        
        disk_encryption_window.setDisable(true);
        disk_encryption_window.setOpacity(0);
        
        main_menu.setDisable(false);
        main_menu.setOpacity(1);
    }
    
   
    @FXML
    private void back_ids(ActionEvent event) {
        
        ids_window.setDisable(true);
        ids_window.setOpacity(0);
        
        main_menu.setDisable(false);
        main_menu.setOpacity(1);
    }

    @FXML
    private void back_ips_window(ActionEvent event) {
        
        ips_window.setDisable(true);
        ips_window.setOpacity(0);
        
        main_menu.setDisable(false);
        main_menu.setOpacity(1);
        
    }
    
   //---------------------------------------------END OF BACK BUTTON FUNCTIONS---------------------------------------------// 
    
    
}
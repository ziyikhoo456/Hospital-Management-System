package src4;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.InsetsUIResource;

//import java.awt.Font;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HospitalManagement extends Application {
	static ArrayList<Lab> laboratory = new ArrayList<Lab>();
	static ArrayList<Facility> facility = new ArrayList<Facility>();
	static ArrayList<Medicines> medicines = new ArrayList<Medicines>();
	static ArrayList<Staff> staff = new ArrayList<Staff>();
	static ArrayList<Doctor> doctor = new ArrayList<Doctor>();
	static ArrayList<Patient> patient = new ArrayList<Patient>();
			
	
	@Override
	public void start(Stage primaryStage){
		
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		MainMenu(primaryStage, pane);
		
		//Set up the scene and title
		Scene scene = new Scene(pane, 740, 500);
		primaryStage.setTitle("Hospital Management");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main (String[] args) {
		
		for(int i = 0; i < 25; i++) {
			doctor.add(new Doctor());
		}
		for(int i = 0; i < 100; i++) {
			patient.add(new Patient());
			medicines.add(new Medicines());
			staff.add(new Staff());
		}
		for(int i = 0; i < 20; i++) {
			laboratory.add(new Lab());
			facility.add(new Facility());
		}
		
		//input information into medicines
		medicines.get(Medicines.getNum()).newMedical("Corex", "Cino pvt", "9-5-2016", 55, 2);
		medicines.get(Medicines.getNum()).newMedical("Nytra", "Ace pvt", "4-4-2015", 500, 1);
		medicines.get(Medicines.getNum()).newMedical("Brufa", "Reckitt", "12-7-2017", 50, 5);
		medicines.get(Medicines.getNum()).newMedical("Pride", "DDF pvt", "12-4-2012", 1100, 1);
		medicines.get(Medicines.getNum()).newMedical("Jardiance", "Medicines pvt", "3-12-2018", 400,20);
		
		doctor.get(Doctor.getNum()).newDoctor("614", "Dr. Khoo Zi Yi", "Psychology", "8AM - 5PM", "MBBS", 35);
		doctor.get(Doctor.getNum()).newDoctor("021", "Dr. Ghanedra", "ENT", "5AM - 11AM", "MBBS,MD", 17);
		doctor.get(Doctor.getNum()).newDoctor("032", "Dr. Vikram", "Physician", "10AM - 3AM", "MBBS, MD", 45);
		doctor.get(Doctor.getNum()).newDoctor("017", "Dr. Rekha", "Surgeon", "8AM -2AM", "BDM", 8);
		doctor.get(Doctor.getNum()).newDoctor("033", "Dr.Pramod", "Artho", "10AM - 4PM", "MBBS,MS", 40);
		
		patient.get(Patient.getNum()).newPatient("222", "Ng Yi Hong", "Fever", "Male", "Y", 20);
		patient.get(Patient.getNum()).newPatient("012", "Pnakaj", "Cancer", "Male", "Y", 30);
		patient.get(Patient.getNum()).newPatient("013", "Sumit", "Cold", "Male", "Y", 23);
		patient.get(Patient.getNum()).newPatient("014", "Alok", "Maleriya", "Male", "Y",45);
		patient.get(Patient.getNum()).newPatient("015", "Ravi", "Diabetes","Male","Y", 25);
		
		laboratory.get(Lab.getNum()).newLab("K-ray", 800);
		laboratory.get(Lab.getNum()).newLab("CT Scan", 1200);
		laboratory.get(Lab.getNum()).newLab("DR Scan", 500);
		laboratory.get(Lab.getNum()).newLab("Blood Bank", 50);
		laboratory.get(Lab.getNum()).newLab("Microscope", 5000);
		
		facility.get(Facility.getNum()).newFacility("Ambulance");
		facility.get(Facility.getNum()).newFacility("Admit Facility");
		facility.get(Facility.getNum()).newFacility("Canteen");
		facility.get(Facility.getNum()).newFacility("Emergency");
		facility.get(Facility.getNum()).newFacility("Day Surgery Unit");
		
		staff.get(Staff.getNum()).newStaff("834", "Loh Jun Xiang", "CEO", "Male", 22000);
		staff.get(Staff.getNum()).newStaff("011", "John", "Domestic Staff", "Male", 3200);
		staff.get(Staff.getNum()).newStaff("053", "Calvin", "Receptionists", "Male", 4500);
		staff.get(Staff.getNum()).newStaff("034", "Lily", "Nurse", "Female", 6700);
		staff.get(Staff.getNum()).newStaff("067", "Flowy", "Health Care Assistant", "Female", 7600);
		
		launch(args);
			
		
	}
	
	public void MainMenu (Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color: lightgrey;");
		pane.setPadding(new Insets(0,10,0,10));
		
		//Welcoming text
		VBox textbox = new VBox();
		Text text = createText("Welcome to Hospital Management System");
		textbox.getChildren().add(text);
		textbox.setAlignment(Pos.CENTER);
		
		Text hr = new Text("=======================================================================================");
		textbox.setPadding(new Insets(20,0,20,0));
		textbox.getChildren().add(hr);
	
		pane.setTop(textbox);
		

		//Display date
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String str = dateFormat.format(date);
		Text datetxt = new Text("Date: "+str);
		datetxt.setFont(Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.REGULAR, 14));
		pane.setLeft(datetxt);

		//Display time
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		String dateStr = timeFormat.format(date);
		Text time = new Text("Time: "+dateStr);
		time.setFont(Font.font("Times New Roman", FontWeight.LIGHT, FontPosture.REGULAR, 14));
		pane.setRight(time);
		
		//Set up main menu
		VBox menu = new VBox(15);
		Text main = new Text("Main Menu:");
		main.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
		menu.getChildren().add(main);
		
		//Set up button options
		Button [] options = new Button [7];
		
		options[0] = new Button("1. Doctors");
		options[1] = new Button("2. Patients");
		options[2] = new Button("3. Medicines");
		options[3] = new Button("4. Laboratories");
		options[4] = new Button("5. Facilities");
		options[5] = new Button("6. Staff");
		options[6] = new Button("7. Exit");

		for (int i = 0; i < options.length;i++) {
			options[i].setPrefWidth(200);
			menu.getChildren().add(options[i]);
		}
		
		menu.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(menu);
		
		//Set on action for Doctors
		options[0].setOnAction(e->{
			clear(pane);
			Doctors(stage, pane);
		});
		
		//Set on action for Patients
		options[1].setOnAction(e->{
			clear(pane);
			Patients(stage, pane);
		});
		
		//Set on action for Medicines
		options[2].setOnAction(e->{
			clear(pane);
			Medicines(stage, pane);
		});
		
		//Set on action for Laboratories
		options[3].setOnAction(e->{
			clear(pane);
			Laboratories(stage, pane);
		});
		
		//Set on action for Facilities
		options[4].setOnAction(e->{
			clear(pane);
			Facilities(stage, pane);
		});
		
		//Set on action for Staff
				options[5].setOnAction(e->{
					clear(pane);
					Staffs(stage, pane);
				});
				
		//Set on action for Exit
		options[6].setOnAction(e -> {
			stage.close();
		});
		
	}
	
	public Text createText (String str) {
		Text text = new Text(str);
		text.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 24));
		return text;
	}
	
	public void clear (BorderPane pane) {
		pane.setTop(null);
		pane.setCenter(null);
		pane.setRight(null);
		pane.setLeft(null);
		pane.setBottom(null);
		pane.setStyle("-fx-background-color: lightgrey;");
	}
	
	public void Doctors(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("DOCTOR SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addDoc(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showDoc(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectDoc(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delDoc(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addDoc (Stage stage,BorderPane pane) {
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("ID");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: 666");
		tf1.setPrefWidth(250);
		Text text2 = new Text ("Name");
		text2.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf2 = new TextField("eg: Tan Liang Wei");
		Text text3 = new Text ("Specialist");
		text3.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf3 = new TextField("eg: Physician");
		Text text4 = new Text ("Work Time");
		text4.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf4 = new TextField("eg: 9AM - 5PM");
		Text text5 = new Text ("Qualification");
		text5.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf5 = new TextField("eg: MBBS, MD");
		Text text6 = new Text ("Room");
		text6.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf6 = new TextField("eg: 18");
		
		//Clear default value
		clearTextField(tf1);
		clearTextField(tf2);
		clearTextField(tf3);
		clearTextField(tf4);
		clearTextField(tf5);
		clearTextField(tf6);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.add(text2,0,2);
		gpane.add(new Text(":"), 1, 2);
		gpane.add(tf2, 2, 2);
		gpane.add(text3,0,3);
		gpane.add(new Text(":"), 1, 3);
		gpane.add(tf3, 2, 3);
		gpane.add(text4,0,4);
		gpane.add(new Text(":"), 1, 4);
		gpane.add(tf4, 2, 4);
		gpane.add(text5,0,5);
		gpane.add(new Text(":"), 1, 5);
		gpane.add(tf5, 2, 5);
		gpane.add(text6,0,6);
		gpane.add(new Text(":"), 1, 6);
		gpane.add(tf6, 2, 6);
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Doctor words design
		VBox banner = docBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			boolean loop=true;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals("")
					|| (tf2.getText()).equals("")
					|| (tf3.getText()).equals("")
					|| (tf4.getText()).equals("")
					|| (tf5.getText()).equals("")
					|| (tf6.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String id = tf1.getText();
				String name = tf2.getText();
				String specialist = tf3.getText();
				String workTime = tf4.getText();
				String qualification = tf5.getText();
				boolean check_id=false;
				try {
					checkDocAddIdExist(id);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(check_id) {
					try {
						checkId(id);
						int room = Integer.parseInt(tf6.getText());	
						doctor.get(Doctor.getNum()).newDoctor(id,name,specialist,workTime,qualification,room);
						message = JLabelMessage("New entry is successfully added!");
						JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
						clear(pane);
						Doctors(stage, pane);
					}
					catch(WrongIdException error){
						message = JLabelMessage("The ID must consist of 3 digits number.");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
						tf1.setText("");
					}
					catch (NumberFormatException error) {
						message = JLabelMessage("Please enter INTEGER value for room!");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
						tf6.setText("");
					};
				}
				}
				
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Doctors(stage, pane);
		});
	}
	
	public VBox docBan() {
		VBox vb = new VBox();
		Text D=new Text("D");
		Text O=new Text("O");
		Text C=new Text("C");
		Text T=new Text("T");
		Text O2=new Text("O");
		Text R=new Text("R");
		Text S=new Text("S");
		
	
		D.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		O.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		C.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		T.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		O2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		R.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		S.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(D,O,C,T,O2,R,S);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
public void showDoc (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = docBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Medicines list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(30);
		list.setVgap(10);

		Text id = new Text("Id");
		Text name = new Text("Name");
		Text specialist = new Text("Specialist");
		Text timing = new Text("Timing");
		Text qualification = new Text("Qualification");
		Text room = new Text("Room No.");
		
		id.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		name.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		specialist.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		timing.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		qualification.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		room.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		
		id.setUnderline(true);
		name.setUnderline(true);
		specialist.setUnderline(true);
		timing.setUnderline(true);
		qualification.setUnderline(true);
		room.setUnderline(true);
		
		list.addRow(0,id,name,specialist,timing,qualification,room);
		
		for (int i = 0; i < Doctor.getNum();i++) {
			String info = doctor.get(i).showDoctorInfo();
			String [] arr = info.split("/");
			Text rowNum = new Text(Integer.toString(i+1));
			rowNum.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Doctors(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectDoc(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the id of the Doctor you want to edit:");
		
		//Get the id of doctor to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the id is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Doctor.getNum(); i++) {
				if (input.equalsIgnoreCase(doctor.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editDoc(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editDoc(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Doctor Banner
		VBox banner = docBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Doctor");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button id = new Button("1. Id");
		Button name = new Button("2. Name");
		Button special = new Button("3. Specialist");
		Button work = new Button("4. Work Time");
		Button qual = new Button("5. Qualification");
		Button room = new Button("6. Room");
		Button back = new Button("7. Back");
		
		id.setMinWidth(200);
		name.setMinWidth(200);
		special.setMinWidth(200);
		work.setMinWidth(200);
		qual.setMinWidth(200);
		room.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		id.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Id:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			boolean check_id=false;
			

			
			if(input != null) {	
				
				try {
					checkDocIdExist(input,target);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(check_id) {
					try {
						checkDocIdExist(input,target);
					}catch(ExistIdException error) {
						message = JLabelMessage("The Id has been used!\nPlease select another Id!");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					}
					try {
					checkId(input);
					doctor.get(target).setId(input);
					message.setText("The Id is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
					}catch(WrongIdException error){
						message = JLabelMessage("The ID must consist of 3 digits number.");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					}		
				}
				
				
			};
		});
		
		name.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new name:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				doctor.get(target).setName(input);
				message.setText("The name is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		special.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new specialist date:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				doctor.get(target).setSpecialist(input);
				message.setText("The specialist is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		work.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new work time:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				doctor.get(target).setWorkTime(input);
				message.setText("The work time is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		qual.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new qualification date:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				doctor.get(target).setQualification(input);
				message.setText("The qualification is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		room.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new room:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if (input != null) {
				try {
					int newRoom = Integer.parseInt(input);
					doctor.get(target).setRoom(newRoom);
					message.setText("The room is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The room must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		back.setOnAction(e -> {
			clear(pane);
			Doctors(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,id,name,special,work,qual,room,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delDoc(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the Id of the doctor you want to delete:");
		
		//Get the id of doctor to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Doctor.getNum(); i++) {
				if (input.equalsIgnoreCase(doctor.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				doctor.remove(target);
				Doctor.setNum(Doctor.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void Patients(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("PATIENT SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addPat(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showPat(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectPat(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delPat(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addPat (Stage stage,BorderPane pane){
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("ID");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: 666");
		tf1.setPrefWidth(250);
		Text text2 = new Text ("Name");
		text2.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf2 = new TextField("eg: Tom");
		Text text3 = new Text ("Disease");
		text3.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf3 = new TextField("eg: Dengue");
		Text text4 = new Text ("Sex");
		text4.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf4 = new TextField("eg: Male");
		Text text5 = new Text ("Admit Status");
		text5.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf5 = new TextField("eg: Y/N");
		Text text6 = new Text ("Age");
		text6.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf6 = new TextField("eg: 22");
		
		clearTextField(tf1);
		clearTextField(tf2);
		clearTextField(tf3);
		clearTextField(tf4);
		clearTextField(tf5);
		clearTextField(tf6);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.add(text2,0,2);
		gpane.add(new Text(":"), 1, 2);
		gpane.add(tf2, 2, 2);
		gpane.add(text3,0,3);
		gpane.add(new Text(":"), 1, 3);
		gpane.add(tf3, 2, 3);
		gpane.add(text4,0,4);
		gpane.add(new Text(":"), 1, 4);
		gpane.add(tf4, 2, 4);
		gpane.add(text5,0,5);
		gpane.add(new Text(":"), 1, 5);
		gpane.add(tf5, 2, 5);
		gpane.add(text6,0,6);
		gpane.add(new Text(":"), 1, 6);
		gpane.add(tf6, 2, 6);
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Patient words design
		VBox banner = patBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals("")
					|| (tf2.getText()).equals("")
					|| (tf3.getText()).equals("")
					|| (tf4.getText()).equals("")
					|| (tf5.getText()).equals("")
					|| (tf6.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String id = tf1.getText();
				String name = tf2.getText();
				String disease = tf3.getText();
				String sex = tf4.getText();
				String admitStatus = tf5.getText();
				boolean check_id=false;
				try {
					checkPatAddIdExist(id);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				if(check_id) {
					
					try {
						checkId(id);
						checkAdmission(admitStatus);
						int age = Integer.parseInt(tf6.getText());
						patient.get(Patient.getNum()).newPatient(id,name,disease,sex,admitStatus.toUpperCase(),age);
						message = JLabelMessage("New entry is successfully added!");
						JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
						clear(pane);
						Patients(stage, pane);
					}
					catch(WrongIdException error){
						message = JLabelMessage("The ID must consist of 3 digits number.");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
						tf1.setText("");
					}
					catch(WrongAdmitException error){
						message = JLabelMessage("The Admit Status must be Y / N.");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
						tf5.setText("");
					}
					catch (NumberFormatException error) {
						message = JLabelMessage("Please enter INTEGER value for age!");
						JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
						
						tf6.setText("");
					};
				}
				}
					
				
				
				
			
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Patients(stage, pane);
		});
	}
	
	public VBox patBan() {
		VBox vb = new VBox();
		Text P=new Text("P");
		Text A=new Text("A");
		Text T=new Text("T");
		Text I=new Text("I");
		Text E=new Text("E");
		Text N=new Text("N");
		Text T2=new Text("T");
		
	
		P.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		A.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		T.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		I.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		E.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		N.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		T2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(P,A,T,I,E,N,T2);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
public void showPat (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = patBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Patients list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(40);
		list.setVgap(10);

		Text id = new Text("Id");
		Text name = new Text("Name");
		Text disease = new Text("Disease");
		Text sex = new Text("Sex");
		Text admit = new Text("Admit Status");
		Text age = new Text("Age");
		
		id.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		name.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		disease.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		sex.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		admit.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		age.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		
		id.setUnderline(true);
		name.setUnderline(true);
		disease.setUnderline(true);
		sex.setUnderline(true);
		admit.setUnderline(true);
		age.setUnderline(true);
		
		list.addRow(0,id,name,disease,sex,admit,age);
		
		for (int i = 0; i < Patient.getNum();i++) {
			String info = patient.get(i).showPatientInfo();
			String [] arr = info.split("/");
			Text rowNum = new Text(Integer.toString(i+1));
			rowNum.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Patients(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectPat(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the id of the patient you want to edit:");
		
		//Get the id of patient to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the id is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Patient.getNum(); i++) {
				if (input.equalsIgnoreCase(patient.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editPat(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editPat(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Patient Banner
		VBox banner = patBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Patient");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button id = new Button("1. Id");
		Button name = new Button("2. Name");
		Button disease = new Button("3. Disease");
		Button sex = new Button("4. Sex");
		Button admit = new Button("5. Admit Status");
		Button age = new Button("6. Age");
		Button back = new Button("7. Back");
		
		id.setMinWidth(200);
		name.setMinWidth(200);
		disease.setMinWidth(200);
		sex.setMinWidth(200);
		admit.setMinWidth(200);
		age.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		id.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Id:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			boolean check_id=false;
			if(input != null) {
				try {
					checkPatIdExist(input,target);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(check_id) {
				try {
				checkId(input);
				patient.get(target).setId(input);
				message.setText("The Id is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}catch(WrongIdException error){
					message = JLabelMessage("The ID must consist of 3 digits number.");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				};
				}
			};
		});
		
		name.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new name:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				patient.get(target).setName(input);
				message.setText("The name is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		disease.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new disease date:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				patient.get(target).setDisease(input);
				message.setText("The disease is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		sex.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new sex:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				patient.get(target).setSex(input);
				message.setText("The sex is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		admit.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new admit status date:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				try {
				checkAdmission(input);
				patient.get(target).setAdmitStatus(input);
				message.setText("The admit status is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}catch(WrongAdmitException error){
					message = JLabelMessage("The Admit Status must be Y / N.");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				};
			};
		});
		
		age.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new age:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if (input != null) {
				try {
					int newAge = Integer.parseInt(input);
					patient.get(target).setAge(newAge);
					message.setText("The age is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The age must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				};
			}
		});
		
		
		back.setOnAction(e -> {
			clear(pane);
			Patients(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,id,name,disease,sex,admit,age,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delPat(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the Id of the patient you want to delete:");
		
		//Get the Id of patient to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the id is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Patient.getNum(); i++) {
				if (input.equalsIgnoreCase(patient.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				patient.remove(target);
				Patient.setNum(Patient.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void Medicines(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("MEDICINE SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addMed(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showMed(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectMed(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delMed(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addMed (Stage stage,BorderPane pane) {
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("Name");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: Dayvigo");
		tf1.setPrefWidth(250);
		Text text2 = new Text ("Manufacturer");
		text2.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf2 = new TextField("eg: Sanchuan Medical Sdn. Bhd.");
		Text text3 = new Text ("Expiry Date");
		text3.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf3 = new TextField("eg: 1-9-2022");
		Text text4 = new Text ("Cost");
		text4.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf4 = new TextField("eg: 100");
		Text text5 = new Text ("Number of Unit ");
		text5.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf5 = new TextField("eg: 1000");
		
		clearTextField(tf1);
		clearTextField(tf2);
		clearTextField(tf3);
		clearTextField(tf4);
		clearTextField(tf5);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.add(text2,0,2);
		gpane.add(new Text(":"), 1, 2);
		gpane.add(tf2, 2, 2);
		gpane.add(text3,0,3);
		gpane.add(new Text(":"), 1, 3);
		gpane.add(tf3, 2, 3);
		gpane.add(text4,0,4);
		gpane.add(new Text(":"), 1, 4);
		gpane.add(tf4, 2, 4);
		gpane.add(text5,0,5);
		gpane.add(new Text(":"), 1, 5);
		gpane.add(tf5, 2, 5);
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Medicine words design
		VBox banner = medBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals("")
					|| (tf2.getText()).equals("")
					|| (tf3.getText()).equals("")
					|| (tf4.getText()).equals("")
					|| (tf5.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String name = tf1.getText();
				String manu = tf2.getText();
				String expire = tf3.getText();
				
				try {
					String [] arr = expire.split("-");
					for(int i = 0; i < arr.length; i++) {
						checkInt(arr[i]);
					}
					checkDate(expire);
					int cost = Integer.parseInt(tf4.getText());
					int unit = Integer.parseInt(tf5.getText());
					medicines.get(Medicines.getNum()).newMedical(name,manu,expire,cost,unit);
					message = JLabelMessage("New entry is successfully added!");
					JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
					clear(pane);
					Medicines(stage, pane);
				}catch (NonIntegerException error) {
					message = JLabelMessage("The date entered contains alphabetical value!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf3.setText("");
				}catch (ArrayIndexOutOfBoundsException error) {
					message = JLabelMessage("Please enter the date with correct format! eg: 12-6-2022");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf3.setText("");
				}catch (InvalidDateException error) {
					message = JLabelMessage("The date entered does not exist!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf3.setText("");
				}catch (NumberFormatException error) {
					message = JLabelMessage("Please enter INTEGER value for cost and unit!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf4.setText("");
					tf5.setText("");
				}catch (Exception error) {
					message = JLabelMessage("Error! Please check if there is any wrong input!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Medicines(stage, pane);
		});
	}
	
	public VBox medBan() {
		VBox vb = new VBox();
		Text M=new Text("M");
		Text e=new Text("E");
		Text d=new Text("D");
		Text i=new Text("I");
		Text i2=new Text("I");
		Text c=new Text("C");
		Text n=new Text("N");
		Text e2=new Text("E");
	
		M.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		e.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		d.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		c.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		i.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		i2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		e2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		n.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(M,e,d,i,c,i2,n,e2);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
	public void showMed (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = medBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Medicines list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(40);
		list.setVgap(10);

		Text name = new Text("Name");
		Text company = new Text("Company");
		Text expire = new Text("Expiry Date");
		Text cost = new Text("Cost");
		Text unit = new Text("Unit");
		
		name.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		company.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		expire.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		cost.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		unit.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		
		name.setUnderline(true);
		company.setUnderline(true);
		expire.setUnderline(true);
		cost.setUnderline(true);
		unit.setUnderline(true);
		
		list.addRow(0,name,company,expire,cost,unit);
		
		for (int i = 0; i < Medicines.getNum();i++) {
			String info = medicines.get(i).findMedical();
			String [] arr = info.split("/");
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Medicines(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectMed(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of medicine you want to edit:");
		
		//Get the name of medicines to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Medicines.getNum(); i++) {
				if (input.equalsIgnoreCase(medicines.get(i).getName())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editMed(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editMed(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Medicine Banner
		VBox banner = medBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Medicine");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button name = new Button("1. Name");
		Button manu = new Button("2. Manufacture");
		Button exp = new Button("3. Expiry Date");
		Button cost = new Button("4. Cost");
		Button unit = new Button("5. Unit");
		Button back = new Button("6. Back");
		
		name.setMinWidth(200);
		manu.setMinWidth(200);
		exp.setMinWidth(200);
		cost.setMinWidth(200);
		unit.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		name.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new name:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				medicines.get(target).setName(input);
				message.setText("The name is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		manu.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new manufacturer:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				medicines.get(target).setManufacturer(input);
				message.setText("The manufacturer is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		exp.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new expiry date:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				try {
				String [] arr = input.split("-");
				for(int i = 0; i < arr.length; i++) {
					checkInt(arr[i]);
				}
				checkDate(input);
				medicines.get(target).setExpiryDate(input);
				message.setText("The expiry date is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (NonIntegerException error) {
					message = JLabelMessage("The date entered contains alphabetical value!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}catch (ArrayIndexOutOfBoundsException error) {
					message = JLabelMessage("Please enter the date with correct format! eg: 12-6-2022");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}catch (InvalidDateException error) {
					message = JLabelMessage("The date entered does not exist!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}catch (Exception error) {
					message = JLabelMessage("Error! Please check if there is any wrong input!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
			};
		});
		
		cost.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new cost:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				try {
					int newCost = Integer.parseInt(input);
					medicines.get(target).setCost(newCost);
					message.setText("The cost is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The cost must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		unit.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new unit:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if (input != null) {
				try {
					int newUnit = Integer.parseInt(input);
					medicines.get(target).setCount(newUnit);
					message.setText("The unit is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The unit must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		back.setOnAction(e -> {
			clear(pane);
			Medicines(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,name,manu,exp,cost,unit,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delMed(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of medicine you want to delete:");
		
		//Get the name of medicines to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Medicines.getNum(); i++) {
				if (input.equalsIgnoreCase(medicines.get(i).getName())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				medicines.remove(target);
				Medicines.setNum(Medicines.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void Laboratories(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("LABORATORIES SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addLab(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showLab(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectLab(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delLab(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addLab (Stage stage,BorderPane pane) {
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("Lab");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: Microscope");
		tf1.setPrefWidth(250);
		Text text2 = new Text ("Cost");
		text2.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf2 = new TextField("eg: 5000");
		
		clearTextField(tf1);
		clearTextField(tf2);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.add(text2,0,2);
		gpane.add(new Text(":"), 1, 2);
		gpane.add(tf2, 2, 2);
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Lab words design
		VBox banner = labBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals("")
					|| (tf2.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String lab = tf1.getText();
				try {
					int cost = Integer.parseInt(tf2.getText());
					laboratory.get(Lab.getNum()).newLab(lab,cost);
					message = JLabelMessage("New entry is successfully added!");
					JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
					clear(pane);
					Laboratories(stage, pane);
				}
				catch (NumberFormatException error) {
					message = JLabelMessage("Please enter INTEGER value for cost!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					
					tf2.setText("");
				};
			}
			
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
			tf2.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Laboratories(stage, pane);
		});
	}
	
	public VBox labBan() {
		VBox vb = new VBox();
		Text L=new Text("L");
		Text A=new Text("A");
		Text B=new Text("B");
	
	
		L.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		A.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		B.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(L,A,B);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
public void showLab (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = labBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Lab list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(100);
		list.setVgap(10);

		Text lab = new Text("Lab");
		Text cost = new Text("Cost");
		
		
		lab.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		cost.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		
		lab.setUnderline(true);
		cost.setUnderline(true);
		
		
		list.addRow(0,lab,cost);
		
		for (int i = 0; i < Lab.getNum();i++) {
			String info = laboratory.get(i).labList();
			String [] arr = info.split("/");
			Text rowNum = new Text(Integer.toString(i+1));
			rowNum.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Laboratories(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectLab(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of the lab you want to edit:");
		
		//Get the name of lab to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Lab.getNum(); i++) {
				if (input.equalsIgnoreCase(laboratory.get(i).getLab())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editLab(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editLab(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Lab Banner
		VBox banner = labBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Lab");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button lab = new Button("1. Lab");
		Button cost = new Button("2. Cost");
		Button back = new Button("3. Back");
		
		lab.setMinWidth(200);
		cost.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		lab.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Lab:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				laboratory.get(target).setLab(input);
				message.setText("The lab is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		cost.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new age:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if (input != null) {
				try {
					int newAge = Integer.parseInt(input);
					laboratory.get(target).setCost(newAge);
					message.setText("The cost is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The cost must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		back.setOnAction(e -> {
			clear(pane);
			Laboratories(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,lab,cost,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delLab(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of the lab you want to delete:");
		
		//Get the name of lab to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Lab.getNum(); i++) {
				if (input.equalsIgnoreCase(laboratory.get(i).getLab())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				laboratory.remove(target);
				Lab.setNum(Lab.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void Facilities(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("FACILITY SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addFac(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showFac(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectFac(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delFac(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addFac (Stage stage,BorderPane pane) {
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("Facility");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: Ambulance");
		tf1.setPrefWidth(250);
		
		clearTextField(tf1);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Facility words design
		VBox banner = facBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String fac = tf1.getText();
				facility.get(Facility.getNum()).newFacility(fac);
				message = JLabelMessage("New entry is successfully added!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				Facilities(stage, pane);
			}
			
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Facilities(stage, pane);
		});
	}
	
	public VBox facBan() {
		VBox vb = new VBox();
		Text F=new Text("F");
		Text A=new Text("A");
		Text C=new Text("C");
		Text I=new Text("I");
		Text L=new Text("L");
		Text I2=new Text("I");
		Text T=new Text("T");
		Text Y=new Text("Y");
	
		F.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		A.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		C.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		I.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		L.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		I2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		T.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		Y.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(F,A,C,I,L,I2,T,Y);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
public void showFac (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = facBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Facility list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(30);
		list.setVgap(10);

		Text fac = new Text("Facility");		
		
		fac.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
	
		fac.setUnderline(true);
		
		list.addRow(0,fac);
		
		for (int i = 0; i < Facility.getNum();i++) {
			String info = facility.get(i).showFacility();
			String [] arr = info.split("/");
			Text rowNum = new Text(Integer.toString(i+1));
			rowNum.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Facilities(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectFac(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of the facility you want to edit:");
		
		//Get the name of facility to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Facility.getNum(); i++) {
				if (input.equalsIgnoreCase(facility.get(i).getFacility())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editFac(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editFac(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Lab Banner
		VBox banner = facBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Facility");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button fac = new Button("1. Facility");
		Button back = new Button("2. Back");
		
		fac.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		fac.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Facility:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				facility.get(target).setFacility(input);
				message.setText("The facility is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		back.setOnAction(e -> {
			clear(pane);
			Facilities(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,fac,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delFac(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the name of the facility you want to delete:");
		
		//Get the name of lab to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Facility.getNum(); i++) {
				if (input.equalsIgnoreCase(facility.get(i).getFacility())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				facility.remove(target);
				Facility.setNum(Facility.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void Staffs(Stage stage, BorderPane pane) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		VBox textBox = new VBox();
		Text text = createText("STAFF SECTION");
		textBox.getChildren().add(text);
		textBox.setPadding(new Insets(30,10,20,10));
		textBox.setAlignment(Pos.CENTER);
		pane.setTop(textBox);
		
		//Option
		VBox option = new VBox(20);
		Button add = new Button("1. Add New Entry");
		Button show = new Button("2. Show Existing list");
		Button edit = new Button("3. Edit An Entry");
		Button delete = new Button("4. Delete An Entry");
		Button back = new Button("5. Back");
		
		add.setMinWidth(200);
		show.setMinWidth(200);
		edit.setMinWidth(200);
		delete.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		add.setOnAction(e ->{
			clear(pane);
			addStaff(stage, pane);
		});
		
		show.setOnAction(e ->{
			clear(pane);
			showStaff(stage, pane);
		});
		
		//JOptionPane
		edit.setOnAction(e ->{
			selectStaff(stage, pane);
		});
		
		//JOptionPane
		delete.setOnAction(e ->{
			delStaff(stage,pane);
		});
		
		back.setOnAction(e -> {
			clear(pane);
			MainMenu(stage, pane);
		});
		
		option.getChildren().addAll(add,show,edit,delete,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		pane.setCenter(option);
	}
	
	public void addStaff (Stage stage,BorderPane pane) {
		VBox wrap = new VBox(30);
		
		pane.setStyle("-fx-background-color:lightblue");
		GridPane gpane = new GridPane();
		gpane.setHgap(20);
		gpane.setVgap(20);
	
		VBox txtbox = new VBox();
		Text txt = createText("Add Form");
		txt.setUnderline(true);
		txtbox.getChildren().add(txt);
		txtbox.setPadding(new Insets(20,0,20,0));
		
		
		gpane.add(txtbox, 0, 0);
		
		//Prompt and get input
		Text text1 = new Text ("Id");
		text1.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf1 = new TextField("eg: 666");
		tf1.setPrefWidth(250);
		Text text2 = new Text ("Name");
		text2.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf2 = new TextField("eg: Tan Liang Hong");
		Text text3 = new Text ("Designation");
		text3.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf3 = new TextField("eg: Executive");
		Text text4 = new Text ("Sex");
		text4.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf4 = new TextField("eg: Male");
		Text text5 = new Text ("Salary");
		text5.setFont(Font.font("Arial",FontWeight.NORMAL, FontPosture.REGULAR, 14));
		TextField tf5 = new TextField("eg: 2500");
		
		clearTextField(tf1);
		clearTextField(tf2);
		clearTextField(tf3);
		clearTextField(tf4);
		clearTextField(tf5);
		
		//Put all into pane
		//gpane.add(child, columnIndex, rowIndex);
		gpane.add(text1,0,1);
		gpane.add(new Text(":"), 1, 1);
		gpane.add(tf1, 2, 1);
		gpane.add(text2,0,2);
		gpane.add(new Text(":"), 1, 2);
		gpane.add(tf2, 2, 2);
		gpane.add(text3,0,3);
		gpane.add(new Text(":"), 1, 3);
		gpane.add(tf3, 2, 3);
		gpane.add(text4,0,4);
		gpane.add(new Text(":"), 1, 4);
		gpane.add(tf4, 2, 4);
		gpane.add(text5,0,5);
		gpane.add(new Text(":"), 1, 5);
		gpane.add(tf5, 2, 5);
		
		
		gpane.setAlignment(Pos.BASELINE_CENTER);
		
		wrap.getChildren().add(gpane);
		
		//Submit button and Clear button
		HBox hbox = new HBox(15);
		Button submit = new Button("Submit");
		Button clear = new Button("Clear");
		Button cancel = new Button("Cancel");
		
		submit.setPrefWidth(70);
		clear.setPrefWidth(70);
		cancel.setPrefWidth(70);
		
		hbox.getChildren().addAll(submit,clear,cancel);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		wrap.getChildren().add(hbox);
		
		pane.setCenter(wrap);
		
		//Staff words design
		VBox banner = staffBan();
		pane.setLeft(banner);
		
		
		//Set on action for submit and clear
		submit.setOnAction(e->{
			boolean empty = false;
			UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
			JLabel message = new JLabel();
		
			if ((tf1.getText()).equals("")
					||(tf2.getText()).equals("")
					||(tf3.getText()).equals("")
					||(tf4.getText()).equals("")
					||(tf5.getText()).equals(""))
				empty = true;
			
			if (!empty) {
				String id = tf1.getText();
				String name = tf2.getText();
				String design = tf3.getText();
				String sex = tf4.getText();
				boolean check_id=false;
				try {
					checkStaffAddIdExist(id);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(check_id) {
				
				try {
					checkId(id);
					int salary = Integer.parseInt(tf5.getText());
					staff.get(Staff.getNum()).newStaff(id,name,design,sex,salary);
					message = JLabelMessage("New entry is successfully added!");
					JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
					clear(pane);
					Staffs(stage, pane);
				}
				catch(WrongIdException error){
					message = JLabelMessage("The ID must consist of 3 digits number.");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf1.setText("");
				}
				catch (NumberFormatException error) {
					message = JLabelMessage("Please enter INTEGER value for salary!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
					tf5.setText("");
				};
			}
			}
			
			else {
				message = JLabelMessage("Warning! Please fill in all the information!");
				JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		
		clear.setOnAction(e ->{
			tf1.setText("");
		});
		
		cancel.setOnAction(e -> {
			clear(pane);
			Staffs(stage, pane);
		});
	}
	
	public VBox staffBan() {
		VBox vb = new VBox();
		Text S=new Text("S");
		Text T=new Text("T");
		Text A=new Text("A");
		Text F=new Text("F");
		Text F2=new Text("F");
		
	
		S.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		T.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		A.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		F.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		F2.setFont(Font.font("Times New Roman",FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		
		vb.getChildren().addAll(S,T,A,F,F2);
		vb.setPadding(new Insets(10,30,10,30));
		vb.setAlignment(Pos.CENTER);
		vb.setStyle("-fx-background-color:yellow");
		return vb;
	}
	
public void showStaff (Stage stage, BorderPane pane) {
		
		pane.setStyle("-fx-background-color: lightblue;");
		
		//Set Banner
		VBox banner = staffBan();
		pane.setLeft(banner);
		
		//Set content
		VBox content = new VBox();

		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Show Existing List");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		
		//Display Staff list
		GridPane list = new GridPane();
		list.setPadding(new Insets(10,10,10,10));
		list.setHgap(50);
		list.setVgap(10);

		Text id = new Text("Id");
		Text name = new Text("Name");
		Text design = new Text("Designation");
		Text sex = new Text("Sex");
		Text salary = new Text("Salary");
		
		id.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		name.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		design.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		sex.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		salary.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 16));
		
		id.setUnderline(true);
		name.setUnderline(true);
		design.setUnderline(true);
		sex.setUnderline(true);
		salary.setUnderline(true);
		
		list.addRow(0,id,name,design,sex,salary);
		
		for (int i = 0; i < Staff.getNum();i++) {
			String info = staff.get(i).showStaffInfo();
			String [] arr = info.split("/");
			Text rowNum = new Text(Integer.toString(i+1));
			rowNum.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
			for (int j = 0; j < arr.length; j++) {
				Text txt = new Text(arr[j]);
				txt.setFont(Font.font("Times New Roman",FontWeight.NORMAL, FontPosture.REGULAR, 16));
				list.add(txt, j, i+1);
			}
		}
		
		list.setStyle("-fx-background-color:lightgreen;-fx-border-width:2px;-fx-border-color:navy");
		list.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(list);
		VBox.setMargin(list, new Insets(0,20,30,20));
		

		//Add button
		HBox btn = new HBox();
		Button back = new Button("Back");
		back.setPrefWidth(70);
		btn.getChildren().add(back);
		btn.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(btn);
		
		//Set back button function
		back.setOnAction(e -> {
			clear(pane);
			Staffs(stage, pane);
		});
		
		pane.setCenter(content);
	};
	
	public void selectStaff(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the id of the staff you want to edit:");
		
		//Get the id of staff to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the id is inside the array
		boolean found = false;
		int target = 999;
		if(input != null) {
			for (int i = 0; i < Staff.getNum(); i++) {
				if (input.equalsIgnoreCase(staff.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				message = JLabelMessage("Success! "+input+" is found!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
				clear(pane);
				editStaff(stage, pane, target);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	};
	
	public void editStaff(Stage stage, BorderPane pane, int target) {
		pane.setStyle("-fx-background-color:lightblue;");
		
		//Staff Banner
		VBox banner = staffBan();
		pane.setLeft(banner);

		//Set content
		VBox content = new VBox();
		
		//Set Title
		HBox section = new HBox();
		Text title = createText("Edit Staff");
		section.getChildren().add(title);
		section.setAlignment(Pos.BASELINE_CENTER);
		section.setPadding(new Insets(20,0,20,0));
		content.getChildren().add(section);
		
		//Option
		VBox option = new VBox(20);
		Text ques = new Text("What do you want to edit?");
		ques.setFont(Font.font(16));
		Button id = new Button("1. Id");
		Button name = new Button("2. Name");
		Button design = new Button("3. Designation");
		Button sex = new Button("4. Sex");
		Button salary = new Button("5. Salary");
		Button back = new Button("6. Back");
		
		id.setMinWidth(200);
		name.setMinWidth(200);
		design.setMinWidth(200);
		sex.setMinWidth(200);
		salary.setMinWidth(200);
		back.setMinWidth(200);
		
		//Set on action
		id.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Id:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			boolean check_id=false;
			if(input != null) {
				try {
					checkStaffIdExist(input,target);
					check_id=true;
				}catch(ExistIdException error) {
					message = JLabelMessage("The Id has been used!\nPlease select another Id!");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(check_id) {
				try {
				checkId(input);
				staff.get(target).setId(input);
				message.setText("The Id is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}catch(WrongIdException error){
					message = JLabelMessage("The ID must consist of 3 digits number.");
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				}
			};
		});
		
		name.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Name:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				staff.get(target).setName(input);
				message.setText("The name is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		design.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Designation:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				staff.get(target).setDesignation(input);
				message.setText("The designation is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		sex.setOnAction(e ->{
			JLabel message = JLabelMessage("Enter a new Sex:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if(input != null) {
				staff.get(target).setSex(input);
				message.setText("The sex is edited successfully!");
				JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
			};
		});
		
		salary.setOnAction(e -> {
			JLabel message = JLabelMessage("Enter a new salary:");
			String input = JOptionPane.showInputDialog(null,message,JOptionPane.QUESTION_MESSAGE);
			if (input != null) {
				try {
					int newSal = Integer.parseInt(input);
					staff.get(target).setSalary(newSal);
					message.setText("The salary is edited successfully!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.INFORMATION_MESSAGE);
				}
				catch (NumberFormatException error) {
					message.setText("Error! The salary must be an integer value!");
					JOptionPane.showMessageDialog(null,message,"Success",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		back.setOnAction(e -> {
			clear(pane);
			Staffs(stage, pane);
		});
		
		
		option.getChildren().addAll(ques,id,name,design,sex,salary,back);
		option.setAlignment(Pos.BASELINE_CENTER);
		content.getChildren().add(option);
		
		pane.setCenter(content);
		
	};
	
	public void delStaff(Stage stage, BorderPane pane) {
		UIManager.put("OptionPane.minimumSize",new Dimension(450,120));
		
		JLabel message = JLabelMessage("Enter the id of the staff you want to delete:");
		
		//Get the name of lab to be edited
		String input = JOptionPane.showInputDialog(null, message, JOptionPane.PLAIN_MESSAGE);
		
		//Check if the name is inside the array
		boolean found = false;
		int target = 999;
		
		if (input != null) {
			for (int i = 0; i < Staff.getNum(); i++) {
				if (input.equalsIgnoreCase(staff.get(i).getId())) {
					found = true;
					target = i;
					break;
				}
			}
			
			if (found) {
				staff.remove(target);
				Staff.setNum(Staff.getNum()-1);
				message = JLabelMessage("Success! "+input+" is deleted!");
				JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				message = JLabelMessage("Error! "+input+" is not found!");
				JOptionPane.showMessageDialog(null, message,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
    
    public JLabel JLabelMessage(String s) {
    	UIManager.put("OptionPane.minimumSize",new Dimension(450,100));
		UIManager.put("OptionPane.buttonFont",new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
		UIManager.put("TextField.font",new FontUIResource(new java.awt.Font("SansSerif",java.awt.Font.BOLD,16)));
		UIManager.put("TextField.margin",new InsetsUIResource(0,0,0,0));
		
		JLabel message = new JLabel(s);
		message.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18));
		return message;
    }
   
   public void clearTextField(TextField tf) {
	   tf.setStyle("-fx-text-fill:gray");
	   tf.setOnMouseClicked(e -> {
			tf.setText("");
			tf.setStyle("-fx-text-fill:black");
		});
   }
   
   public void checkId(String ID) throws WrongIdException {
		boolean valid = true;
		if(ID.length() == 3) {
			for(int i = 0; i < ID.length(); i++)
				if(Character.isDigit(ID.charAt(i)) == false)
					valid = false;
		}
		else
			valid = false;
		
		if(valid == false)
			throw new WrongIdException();
	}
   
   public void checkDocIdExist(String ID,int target) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Doctor.getNum(); i++) {
				if(i!=target) {
					if (ID.equalsIgnoreCase(doctor.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
				
			}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkPatIdExist(String ID,int target) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Patient.getNum(); i++) {
				if(i!=target) {
					if (ID.equalsIgnoreCase(patient.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
				
			}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkStaffIdExist(String ID,int target) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Staff.getNum(); i++) {
				if(i!=target) {
					if (ID.equalsIgnoreCase(staff.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
				
			}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkDocAddIdExist(String ID) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Doctor.getNum(); i++) {
					if (ID.equalsIgnoreCase(doctor.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkPatAddIdExist(String ID) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Patient.getNum(); i++) {
					if (ID.equalsIgnoreCase(patient.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkStaffAddIdExist(String ID) throws ExistIdException {
	   boolean valid=true;
			for (int i = 0; i < Staff.getNum(); i++) {
					if (ID.equalsIgnoreCase(staff.get(i).getId())) {
						valid=false;
						break;
						
					}
					else
						valid=true;
				}
			
		if(valid == false)
			throw new ExistIdException();
	}
   
   public void checkAdmission (String admit) throws WrongAdmitException{
	   System.out.println(admit);
	   
	   boolean valid = true;
	   //if(admit.length() == 1) {
		   System.out.println("length correct");
		   System.out.println(admit);
		   if(!admit.equalsIgnoreCase("y")&&!admit.equalsIgnoreCase("n")) {
			   System.out.println("not y or n");
			   valid = false;
		   }
	  // }
	   System.out.println(valid);
	   if(valid == false)
			throw new WrongAdmitException();
   }
   
   public void checkDate(String date) throws Exception {
	   String [] array = date.split("-");
		   int day = Integer.parseInt(array[0]);
		   int month = Integer.parseInt(array[1]);
		   int year = Integer.parseInt(array[2]);
		   if (month < 1 || month > 12)
			   throw new InvalidDateException();
		   if (day < 1 || day > 31)
			   throw new InvalidDateException();
		   if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
			   throw new InvalidDateException();
		   if (month == 2 && year%4 == 0 && day > 29)
				throw new InvalidDateException();
		   if (month == 2 && year%4 != 0 && day > 28)
				throw new InvalidDateException();
   }
   
   public void checkInt(String str) throws Exception{
	   for (int i = 0; i < str.length(); i++) {
		   if (Character.isDigit(str.charAt(i)) == false)
			   throw new NonIntegerException();
	   }
   }
}

class WrongIdException extends Exception{
	public WrongIdException () {
		super("The ID must consist of 3 digits number.");
	}
}

class ExistIdException extends Exception{
	public ExistIdException () {
		super("The edited Id already used by others!\\nPlease enter another Id!");
	}
}

class WrongAdmitException extends Exception{
	public WrongAdmitException() {
		super("The Admit Status must be Y / N.");
	}
}
	
class InvalidDateException extends Exception{
	public InvalidDateException() {
		super("The date does not exist!");
	}
}

class NonIntegerException extends Exception{
	public NonIntegerException() {
		super("Please input integer!");
	}
}
	
package com.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.student.beans.Student;
import com.student.beans.StudentWitMarks;
import com.student.beans.Studentmarks;


public class StudentServices {
	private Scanner scanner ;
	private Studentmarks[] studentmarks;
	private List<Student> students = new ArrayList<Student>();
	private Student student;
	private StudentWitMarks studentWitMarks;
	private List<StudentWitMarks> studentWitMarksL = new ArrayList<StudentWitMarks>();
	
	
	// Student Data Entry
	public void setStudentData() {
		scanner=new Scanner(System.in);
		
		
		// Enter Student Name and Id
		System.out.println("Enter Studfent ID (number): ");
		student = new Student();
		student.setStudentID(scanner.nextInt());
		System.out.println("Enter Student Namem (string) : ");
		String name= scanner.next();
		student.setName(name);
		
		// Enter Student Marks 
		studentmarks = new Studentmarks[5];
		for(int i =0 ;i<studentmarks.length;i++) {
			 studentmarks[i] = new Studentmarks();
			 int nm = i+1;
			 System.out.println("Enter Course ID "+"["+nm+"]");
			 studentmarks[i].setCoursID(scanner.nextInt());
			 System.out.println("Enter Course marks"+"["+nm+"]");
			 studentmarks[i].setMarks(scanner.nextDouble()); 
			 
		}
		student.setStudentmarks(studentmarks);
		students.add(student);
		
		for(Student student:students) {	    
		      studentWitMarks = new StudentWitMarks();  
			  //Adding name , total marks and average to studentDetails to be used for calculation
			  studentWitMarks.setName(student.getName());
			  studentWitMarks.setTotal(getStudentTotal(student));
			  studentWitMarks.setAverage(getStudentPrecentage(student));
	    	  studentWitMarksL.add(studentWitMarks);	  
	  }
		
	}
	
	
	
	// Display names with percentage for every student method
	public void displayStudentNames() {
		System.out.println("============ Name and precentage ===============");
		  System.out.println(" Name       :    Average");
		  for(Student student:students) {	      
				  System.out.println(" "+student.getName()+"      :   "+getStudentPrecentage(student));	  
		  }  
	   }
	
	
	//  Display name with  maximum marks for every student method
	public void displyNamesWitMax() {
		System.out.println("============ Name with  maximum marks for every student  ============");
		  System.out.println(" Name       :  Maximum Marks");
		  for(Student student:students) {	    
			      studentWitMarks = new StudentWitMarks();
			      
			      // Calling private method to calculate maximum marks for student
				  System.out.println(" "+student.getName()+"     : "+getMaxMrks(student));
			
		  }
	}
	
	
    // Display Name Wit Maximum Marks of all students method
	public void displyNameWitMaxMarks() {
		System.out.println("============ Student names and maximum  Marks of all students ===============");
		  System.out.println("Name      : total");
		  double mx=0.0;
		  StudentWitMarks studentMax =  studentWitMarksL.get(0);
		  StudentWitMarks studentMX = new StudentWitMarks();
		  mx = studentMax.getTotal();
		  
		  for(StudentWitMarks studentMaxs:studentWitMarksL) {	
				  if(studentMaxs.getTotal() >= mx) {
						mx = studentMaxs.getTotal();
						studentMX.setName(studentMaxs.getName());
						studentMX.setTotal(mx);
					}   
		  }
		  System.out.print(studentMX.getName()+"     :  "+studentMX.getTotal());	
	}
	
	
    // Display student name with maximum average score method
	public void displyMaxAvgWiNms() {
		System.out.println("============ Student name with maximum average ===============");
		  System.out.println("Name      :  maximum average");
		  double mx=0.0;
		  StudentWitMarks studentMax =  studentWitMarksL.get(0);
		  StudentWitMarks studentMX = new StudentWitMarks();
		  mx = studentMax.getAverage();
		  
		  for(StudentWitMarks studentMaxs:studentWitMarksL) {	
				  if(studentMaxs.getAverage() >= mx) {
						mx = studentMaxs.getAverage();
						studentMX.setName(studentMaxs.getName());
					} 	  
		  }
		  System.out.print(studentMX.getName()+"     :  "+mx);
	}
	
	
    // Display number of pass students method
	public void displyPassStnds() {
		System.out.println("============ Number of pass students  ===============");
		  int count=0;
		  int studentP = 0;
		  for(Student student:students) {	
			  for(int i=0;i<student.getStudentmarks().length;i++) {
				  if(student.getStudentmarks()[i].getMarks()>= 50) {
						count++;
						System.out.println(count);
					} 
				  if(count==5) {
					  studentP++;
				  }
			  }	  
			  count=0;
		  }
		  System.out.print("Number of Pass Student : " +studentP);	  
	}
	
	
	
//  Display failed  students and names
	public void displyFailStnds() {
		System.out.println("============  failed  students  ===============");
		 System.out.println("Name      : " + " average");
		 int count=0;
		  int studentP = 0;
		  for(Student student:students) {	
			  for(int i=0;i<student.getStudentmarks().length;i++) {
				  if(student.getStudentmarks()[i].getMarks()<= 50) {	 
					  count++;
					}			  
			  }
			  if(count>0) {
				  System.out.println(student.getName()+ " : "+getStudentPrecentage(student));
				  }
			  count=0; 
		  }  
	}
	
	
	
	// Get Student Average method
	private Double getStudentPrecentage(Student student) {
		Double sum=0.0;
		Double avg=0.0;
		for(int i=0;i<student.getStudentmarks().length;i++) {
			sum = sum+student.getStudentmarks()[i].getMarks();
		}
		avg = sum/5;
		return avg;
	}
	
	
	// Get Student Total marks
		private Double getStudentTotal(Student student) {
			Double sum=0.0;
			for(int i=0;i<student.getStudentmarks().length;i++) {
				sum = sum+student.getStudentmarks()[i].getMarks();
			}
			return sum;
		}
		
	
	
	
	// Get maximum marks method
	private Double getMaxMrks (Student student) {

		Double max= student.getStudentmarks()[0].getMarks();
		for(int i=0;i<student.getStudentmarks().length;i++) {
			
			if(student.getStudentmarks()[i].getMarks() >= max) {
				max = student.getStudentmarks()[i].getMarks();
			}
		}
		
		return max;
		
	}
	
	
}

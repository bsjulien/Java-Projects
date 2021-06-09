Check in and out program 

Authors:

- Julien Barezi
- Gihozo Landelin

Project description:

We designed this project in order to help universities specifically ALU to ease the recording of 
students, staff and visitors that comes in school.When a student comes in school, the person 
responsible for recording ask him/her name, studentid and email which system checks if the student 
exist in the ALU database. If the system finds the student exist, the recorder clicks checkin
button and the student info is added in the list of students currently in school alongside with 
the time when he/she came in. 

The process also is applied when checking in a staff or a visitor. For staff, the system
checks in the ALU staff database and here an new column is added which is the role 
or what the staff does in ALU. For Visitors, their NationalID or Passport number is recorded
in the place of visitorsid. A new column is also added here which is motif or what brings 
the visitor in ALU. 

For checking out, the recorder has to select a row in either student table (for student checkout)
or staff table (for staff checkout) or visitors table(for visitor checkout) and then press the
checkout button. By pressing, the person is removed from the table and the time he/she is checkedout
is recorded and shown when the recorder wants to view the daily report.

To view the daily report of all people(students, staff, visitors) that came in school, the recorder
simply click on view report button located at the top right corner of the active interface. 
The report shows 3 tables where students, staff and visitors that came in school are recorded. 
The tables shows the person information and the time he came in(checked in) and the time 
he left(checked out). If he/she hasn't left yet, the time out column indicates "Not yet". 


More details on the project:


- Student and Staff database are in form of a text file where they are called students_database.txt
and staff_database.txt respectively. These files are stored alongside with the project files. 

- Any other ID, name or email that doesn't match with the records in student and staff database
will not be accepted for checkin, so you have to first look for these data. 

- The sequence of the program files starts on Main.java -> Checkinandout_info.java -> DisplayAll.java

- If you open the DisplayAll.java file immediately, it won't show anything because it is linked to the 
Checkinandout_info.java file. To access it, you have to first pass in Checkinandout_info.java file
and click view report button as stated above. 

Thank you for using our program - Enjoy!!!!



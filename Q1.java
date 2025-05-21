class Student{
  private int studentId;
  private String name;
  private int daysAttend;
  
  Student(int stid,String nm,int Da){
    studentId = stid;
    name = nm;
    daysAttend = Da;
  }
  
  public int getStudentId(){
    return studentId;
  }
  
  public String getName(){
    return name;
  }
  
  public int getDays(){
    return daysAttend;
  }
  
  public void setStudentId(int id){
    studentId = id;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public void setDaysAttended(int days){
    daysAttend = days;
  }

}

class ClassRoom{
  int classStudentsId[] = new int[9];
  String classStudentsName[] = new String[9];
  int classStudentsDays[] = new int[9];
  int numberStudents = 0;
  
  public void addStudent(String name,int id,int days){
    if(numberStudents <= 9){
      classStudentsId[numberStudents] = id;
      classStudentsName[numberStudents] = name;
      classStudentsDays[numberStudents] = days;
      numberStudents++;
    }
  }
  
  public boolean validateID(int id){
    for(int item:classStudentsId){
      if(item == id){
        return true;
      }
    }
    return false;
  }
  
  public void dispalyData(int id){
    if(validateID(id)){
      for(int i = 0; i <= numberStudents; i++){
        if(id == classStudentsId[i]){
          System.out.println("name: "+ classStudentsName[i]);
          System.out.println("id: "+ classStudentsId[i]);
          System.out.println("Attendens: "+ classStudentsDays[i]);
        }
      
      }
    } else {
      System.out.println("No Student Availabale");
    }
    
  }
  
  public void updateDate(int stid,int day){
    for(int i = 0; i <= numberStudents;i++){
      if(classStudentsId[i] == stid){
        classStudentsDays[i] = day;
      }
    }
  }

}

class p01{
  public static void main(String[] args){
    ClassRoom class01 = new ClassRoom();
    
    Student st1 = new Student(101,"Nimali",12);
    Student st2 = new Student(102,"Tharushi",15);
    Student st3 = new Student(103,"Kasuni",9);
    
    class01.addStudent(st1.getName(),st1.getStudentId(),st1.getDays());
    class01.addStudent(st2.getName(),st2.getStudentId(),st2.getDays());
    class01.addStudent(st3.getName(),st3.getStudentId(),st3.getDays());
    
    class01.updateDate(102,16);
    
    class01.dispalyData(101);
    class01.dispalyData(102);
    class01.dispalyData(103);
    
    
    
  }
}

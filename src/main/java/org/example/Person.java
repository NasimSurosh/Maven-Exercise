package org.example;

public class Person {

  private Integer ID;
  private String name;
  private String lastName;
  private Integer age;
  public Person(int id, String first, String last, int age) {
   this.ID = id;
   this.name = name;
   this.lastName = lastName;
   this.age = age;
  }
  public Integer getID() {
    return ID;
  }
  public String getName() {
    return name;
  }
  public String getLastName() {
    return lastName;
  }
  public Integer getAge() {
    return age;
  }
  public void setID(Integer iD) {
    ID = iD;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
  
  
}

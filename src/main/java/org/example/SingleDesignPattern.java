package org.example;

public class SingleDesignPattern {

  static class Person {
    private final int id;
    private final String name;
    private final int salary;

    private Person(Builder builder) {
      this.id = builder.id;
      this.name = builder.name;
      this.salary = builder.salary;
    }

    public static class Builder {
      private int id;
      private String name;
      private int salary;

      public Builder setId(int id) {
        this.id = id;
        return this;
      }

      public Builder setName(String name) {
        this.name = name;
        return this;
      }

      public Builder setSalary(int salary) {
        this.salary = salary;
        return this;
      }

      public Person build() {
        return new Person(this);
      }
    }
  }

  public static void main(String[] args) {
    Person person = new Person.Builder()
            .setId(1)
            .setName("ujjval")
            .setSalary(100)
            .build();

    System.out.println("Person created: ID=" + person.id + ", Name=" + person.name + ", Salary=" + person.salary);
  }
}

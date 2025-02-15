package org.example;

public class CommandDesignPattern {
  class CommandRunner {
    public void execute(Command command) {
      command.run();
    }
  }

  interface Command extends Runnable{
  }


  class Sms {
    public void sendSms() {
      System.out.println("Sending sms...");
    }
  }

  class Email {
    public void sendEmail() {
      System.out.println("Sending email...");
    }
  }

  class SmsJob implements Command {
    Sms sms;
    public SmsJob(Sms sms) {
      this.sms = sms;
    }

    @Override
    public void run() {
      sms.sendSms();
    }
  }

  class EmailJob implements Command {
    Email email;
    public EmailJob(Email email) {
      this.email = email;
    }

    @Override
    public void run() {
      email.sendEmail();
    }
  }

  public static void main(String[] args) {
    CommandDesignPattern obj = new CommandDesignPattern();
    obj.execute();
  }

  private void execute() {
    Sms sms = new Sms();
    Email email = new Email();
    SmsJob smsJob = new SmsJob(sms);
    EmailJob emailJob = new EmailJob(email);
    CommandRunner commandRunner = new CommandRunner();
    commandRunner.execute(smsJob);
    commandRunner.execute(emailJob);

  }
}

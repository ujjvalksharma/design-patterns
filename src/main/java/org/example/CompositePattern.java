package org.example;

import java.util.List;

public class CompositePattern { //this represents hierarchy

  interface Node {
    String getText();
  }

  class LeafNode implements Node {
    String text;
    public LeafNode(String text) {
      this.text = text;
    }
    @Override
    public String getText() {
      return "<li>" + this.text + "<li>";
    }
  }

  class CompositeNode implements Node {
    List<Node> nodes;
    public CompositeNode(List<Node> nodes) { //In decorator design only 1 instance of Node is passed, however, in Composite multiple
      this.nodes = nodes;
    }
    @Override
    public String getText() {
      String result = "<ul>";
      for(Node n : nodes) {
        result += "\n" + n.getText();
      }
      result += "\n</ul>";
      return result;
    }
  }

  public static void main(String[] args) {
    CompositePattern compositePattern = new CompositePattern();
    compositePattern.execute();
  }

  private void execute() {
    Node empty = new LeafNode("hello world");
    Node composite1 = new CompositeNode(List.of(empty));
    System.out.println("composite1: \n" + composite1.getText());
    Node composite2 = new CompositeNode(List.of(composite1));
    System.out.println("composite2: \n" + composite2.getText());
  }
}

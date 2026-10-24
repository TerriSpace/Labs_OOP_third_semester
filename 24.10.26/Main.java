import java.util.*;

interface Chair {
  void makeChair();
  void deliverChair();
}

class DecorChair implements Chair {
  @Override
  public void makeChair() {
    System.out.println("Делаю декоративный стул");
    System.out.println("Вырезаю узор на спинке и покрываю лаком");
  }

  @Override
  public void deliverChair() {
    System.out.println("Упаковываю стул в подарочную упаковку");
  }
}

class Stool implements Chair {
  @Override
  public void makeChair() {
    System.out.println("Делаю табуретку");
    System.out.println("Сколачиваю ножки");
    System.out.println("Прикручиваю сиденье");
  }

  @Override
  public void deliverChair() {
    System.out.println("Упаковываю табуретку в обычную плёнку");
  }
}

interface Table {
  void makeTable();
  void deliverTable();
}

class DecorTable implements Table {
  @Override
  public void makeTable() {
    System.out.println("Делаю декоративный стол");
    System.out.println("Вырезаю узор на столешнице и покрываю лаком");
  }

  @Override
  public void deliverTable() {
    System.out.println("Упаковываю стол в подарочную упаковку");
  }
}

class DiningTable implements Table {
  @Override
  public void makeTable() {
    System.out.println("Делаю обеденный стол");
    System.out.println("Собираю каркас");
    System.out.println("Прикручиваю столешницу");
  }

  @Override
  public void deliverTable() {
    System.out.println("Упаковываю стол в обычную плёнку");
  }
}

enum ChairType {
  DECOR ("DecorChair"),
  STOOL ("Stool");

  private final String description;

  ChairType(String description) {
    this.description = description;
  }
}

enum TableType {
  DECOR ("DecorTable"),
  DINING ("DiningTable");

  private final String description;

  TableType(String description) {
    this.description = description;
  }
}

abstract class FurnitureFactory {
  protected abstract Chair createChair(ChairType type);
  protected abstract Table createTable(TableType type);

  public void takeChairOrder(ChairType type) {
    Chair chair = createChair(type);
    chair.makeChair();
    chair.deliverChair();
  }

  public void takeTableOrder(TableType type) {
    Table table = createTable(type);
    table.makeTable();
    table.deliverTable();
  }
}

class ClassicFurnitureFactory extends FurnitureFactory {
  @Override
  protected Chair createChair(ChairType type) {
    System.out.println("Делаем стулья в классическом стиле");
    if (type == ChairType.DECOR) {
      return new DecorChair();
    } else {
      return new Stool();
    }
  }

  @Override
  protected Table createTable(TableType type) {
    System.out.println("Делаем столы в классическом стиле");
    if (type == TableType.DECOR) {
      return new DecorTable();
    } else {
      return new DiningTable();
    }
  }
}

class ModernFurnitureFactory extends FurnitureFactory {
  @Override
  protected Chair createChair(ChairType type) {
    System.out.println("Делаем стулья в современном стиле");
    if (type == ChairType.DECOR) {
      return new DecorChair();
    } else {
      return new Stool();
    }
  }

  @Override
  protected Table createTable(TableType type) {
    System.out.println("Делаем столы в современном стиле");
    if (type == TableType.DECOR) {
      return new DecorTable();
    } else {
      return new DiningTable();
    }
  }
}


public class Main {
    public static void main(String[] args) {
      FurnitureFactory factory = new ClassicFurnitureFactory();
      factory.takeChairOrder(ChairType.DECOR);
      System.out.println();
      factory.takeTableOrder(TableType.DINING);


      factory = new ModernFurnitureFactory();
      factory.takeChairOrder(ChairType.STOOL);
      System.out.println();
      factory.takeTableOrder(TableType.DECOR);
    }
}
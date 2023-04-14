package com.hillel.rosenko.lessons.lesson14.phonebook;
import java.io.PrintStream;
import lombok.SneakyThrows;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class PhoneBookTest {
  private PhoneBook phoneBook;
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule();

  @SneakyThrows
  @BeforeEach
  public void setup() {
    phoneBook = new PhoneBook();
    SystemOutRule systemOutRule = new SystemOutRule();
    System.setOut(new PrintStream(systemOutRule.getLog()));
  }

  @Test
  void testAddRecord() {
    phoneBook.add("Ihor", "123-456-7890");
    phoneBook.add("Ola", "987-654-3210");
    Assertions.assertEquals(2, phoneBook.phoneBook.size());
  }

  @Test
  void testFindRecord() {
    phoneBook.add("Vova", "123-456-7890");
    phoneBook.add("Kate", "987-654-3210");
    phoneBook.find("Vova");
    Assertions.assertEquals("Record {name='Vova', phoneNumber='123-456-7890'}", phoneBook.phoneBook.get("Vova"));
  }

  @Test
  void testFindAllRecords() {
    phoneBook.add("Kate", "123-456-7890");
    phoneBook.add("Semen", "123-456-7890");
    phoneBook.add("Ola", "123-456-7890");
    phoneBook.findAll("Kate");
    Assertions.assertEquals("[Record {name='Kate', phoneNumber='123-456-7890'},\n", systemOutRule.getLog());
  }
// не працює(


}
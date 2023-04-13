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
    phoneBook.add("John", "123-456-7890");
    phoneBook.add("Jane", "123-456-7890");
    phoneBook.add("Jim", "123-456-7890");
    phoneBook.findAll("J");
    Assertions.assertEquals("[Record {name='John', phoneNumber='123-456-7890'}, Record {name='Jane', phoneNumber='987-654-3210'}]\n", systemOutRule.getLog());
  }


  @Test
  void find() {
  }

  @Test
  void findAll() {
  }
}
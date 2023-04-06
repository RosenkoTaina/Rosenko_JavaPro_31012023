package com.hillel.rosenko.lessons.lesson13;

public class ArrayTransfer {
    ArrayTransfer() {
  }

  public static int[] getTransferArray(int[] array) throws ArrayDataException {
    int key = 4;
    int keyPosition = -1;
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == key) {
        keyPosition = i;
        break;
      }
    }
    if (keyPosition == -1) {
      // якщо четвірка не знайдена, вийняток
      throw new ArrayDataException("Незнайдено ключ");
    }  else if(keyPosition == array.length - 1) {
      // якщо немає значень після четвірки
        throw new ArrayDataException("Немає значень після четвірки");
    } else {
      // якщо четвірка знайдена, повернути новий масив з елементами після неї
      int[] result = new int[array.length - keyPosition - 1];
      System.arraycopy(array, keyPosition + 1, result, 0, result.length);
      return result;
    }
  }

  public static boolean doesArrayContainNumbers(int[] array) {
    int firstKey = 1;
    int secondKey = 4;
    boolean firstKeyConditionState = false;
    boolean secondKeyConditionState = false;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == firstKey) {
        firstKeyConditionState = true;
      } else if (array[i] == secondKey) {
        secondKeyConditionState = true;
      } else {
        return false;
      }
    }
    return firstKeyConditionState && secondKeyConditionState;
  }

}
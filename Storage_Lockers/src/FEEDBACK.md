This is a solid beginner project that demonstrates good understanding of classes, objects, and basic Java concepts. You are clearly thinking about separation of concerns and error handling.

**OVERALL: PASSED**

Minor Tweaks:

* **Code Duplication**: The locker validation logic is repeated in cases 2 and 3. Consider moving that to a shared method.

* **Case Spacing**: Put the : against the case value:

  ```java
  // Current:
  case "1" : {
  // Should be:
  case "1": {
  ```

* **Private By Default**: `generatePin()` is only used internally, it should be private.

* **Method Usage**: You made methods, use them! =)

  ```java
  // Current (mixed approaches):
  if (lockers[i].getPin() == null) // in rentLocker()
  if (locker.getPin() == null) // in areLockersFull()
  
  // Better: Use the existing isRented() method consistently:
  if (!lockers[i].isRented())
  if (!locker.isRented())
  ```

  
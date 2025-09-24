package edu.ccrm.util;

/**
 * This class is not directly used but serves as a clear, isolated example
 * of bitwise operators for managing permissions.
 */
public class PermissionManager {

    // Define permissions as powers of 2
    public static final int READ_PERMISSION = 1;    // 0001
    public static final int WRITE_PERMISSION = 2;   // 0010
    public static final int EXECUTE_PERMISSION = 4; // 0100
    public static final int DELETE_PERMISSION = 8;  // 1000

    public static void demonstrateBitwiseOperations() {
        System.out.println("--- Bitwise Operator Demonstration ---");
        
        // Let's say a user has READ and WRITE permissions
        int userPermissions = READ_PERMISSION | WRITE_PERMISSION; // 0001 | 0010 = 0011 (3)
        System.out.println("User has permissions: " + Integer.toBinaryString(userPermissions));
        
        // To check if a user has a specific permission, use bitwise AND
        boolean canRead = (userPermissions & READ_PERMISSION) == READ_PERMISSION; // (0011 & 0001) -> 0001
        boolean canExecute = (userPermissions & EXECUTE_PERMISSION) == EXECUTE_PERMISSION; // (0011 & 0100) -> 0000

        System.out.println("Does user have READ permission? " + canRead);
        System.out.println("Does user have EXECUTE permission? " + canExecute);
        
        // This demonstrates a common and efficient use case for bitwise operators.
        System.out.println("------------------------------------");
    }
}
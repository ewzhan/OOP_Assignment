// Method to show and edit details of a supplier
public void showSupplier() {
    if (supplierCount == 0) {  // Check if no suppliers available
        System.out.println("No suppliers available to display.");
        return;
    }

    int choice = -1;

    System.out.println("\nShow supplier details:");
    System.out.println("1. Show all supplier details");
    System.out.println("2. Show supplier details by ID (search)");
    System.out.println("3. Show supplier details by Name (search)");

    do {
        System.out.print("Enter your choice -> ");
        try {
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Show all supplier details
                    if (supplierCount == 0) {
                        System.out.println("No suppliers to show.");
                    } else {
                        for (int i = 0; i < supplierCount; i++) {
                            System.out.println(suppliers[i]);
                        }
                    }
                    break;

                case 2:
                    // Search supplier by ID
                    searchSupplierByID();
                    break;

                case 3:
                    // Search supplier by Name
                    searchSupplierByName();
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();  // Clear invalid input
        }
    } while (choice != 1 && choice != 2 && choice != 3);  // Exit if one of the valid choices is made
}

// Method to search and show supplier details by ID
private void searchSupplierByID() {
    while (true) {
        System.out.print("\nEnter Supplier ID to show (enter 999 to go back): ");
        int supplierID = sc.nextInt();

        if (supplierID == 999) {
            return;  // Go back to previous menu
        } else if (supplierID <= 0 || supplierID > supplierCount) {
            System.out.println("Invalid ID entered. Please try again.");
        } else {
            Supplier supplier = findSupplierByID(supplierID);
            if (supplier != null) {
                System.out.println(supplier);
                // Offer additional options to view orders, product supplies, or edit the supplier
                offerSupplierOptions(supplier);
            } else {
                System.out.println("Supplier not found.");
            }
            break;  // Exit after showing or editing
        }
    }
}

// Method to search and show supplier details by name
private void searchSupplierByName() {
    System.out.print("\nEnter Supplier Name to show: ");
    String supplierName = sc.nextLine().toLowerCase();

    boolean found = false;
    for (int i = 0; i < supplierCount; i++) {
        if (suppliers[i].getSupplierName().toLowerCase().contains(supplierName)) {
            System.out.println(suppliers[i]);
            // Offer additional options to view orders, product supplies, or edit the supplier
            offerSupplierOptions(suppliers[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No suppliers found with the name: " + supplierName);
    }
}

// Method to offer options after displaying supplier details
private void offerSupplierOptions(Supplier supplier) {
    int choice = -1;
    do {
        System.out.println("\nOptions for supplier: " + supplier.getSupplierName());
        System.out.println("1. Edit supplier details");
        System.out.println("2. Show orders with this supplier");
        System.out.println("3. Show product supplies by this supplier");
        System.out.println("4. Back to main menu");

        System.out.print("Your choice -> ");
        try {
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Edit supplier details
                    editSupplier(supplier);
                    break;

                case 2:
                    // Show orders done with the supplier (using Order class)
                    showOrdersBySupplier(supplier);
                    break;

                case 3:
                    // Show product supplies by this supplier (using ProductSupplyList class)
                    showProductSuppliesBySupplier(supplier);
                    break;

                case 4:
                    System.out.println("Going back to the menu.");
                    return;  // Exit the method

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();  // Clear invalid input
        }
    } while (choice != 4);
}

// Method to show orders done with this supplier
private void showOrdersBySupplier(Supplier supplier) {
    System.out.println("\nOrders made with supplier: " + supplier.getSupplierName());

    boolean found = false;
    for (int i = 0; i < orderCount; i++) {
        if (orders[i].getSupplier().equals(supplier)) {
            System.out.println(orders[i]);
            found = true;
        }
    }

    if (!found) {
        System.out.println("No orders found for this supplier.");
    }
}

// Method to show product supplies by this supplier (ProductSupplyList class)
private void showProductSuppliesBySupplier(Supplier supplier) {
    System.out.println("\nProduct supplies by supplier: " + supplier.getSupplierName());
    productSupplyList.displaySuppliesBySupplier(supplier);
}

// Method to edit a supplier's details
private void editSupplier(Supplier supplier) {
    System.out.println("\nEditing Supplier: " + supplier.getSupplierName());

    // Get new details with validation
    String newSupplierName = getStringInput("New Supplier Name: ");
    String newSupplierAddress = getStringInput("New Supplier Address: ");
    String newSupplierContact = getStringInput("New Supplier Contact: ");

    // Update supplier details
    supplier.setSupplierName(newSupplierName);
    supplier.setSupplierAddress(newSupplierAddress);
    supplier.setSupplierContact(newSupplierContact);

    System.out.println("Supplier details updated successfully.");
}

// Helper method to get user input for strings
private String getStringInput(String prompt) {
    System.out.print(prompt);
    return sc.nextLine().trim();
}

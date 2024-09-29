/* Write an application that converts between meters and feet. Its first command-
line argument is a number and second command line argument is either
"centimeter" or "meter". If the argument equals "centimeter" displays a string
reporting the equivalent number of meters. If this argument equals "meters",
display a string reporting the equivalent number of centimeter. If unit is not given
properly then generate custom exception Unitformatexception. If first argument is
not proper format then generate numberformatexception. Generate other
exception as per requirements. (1 meter=100 centimeter) */
class UnitFormatException extends Exception {
    public UnitFormatException(String message) {
        super(message);
    }
}

class U4P4 {
    public static void main(String args[]) {
        if (args.length != 2) {
            printMessage("\nPlease enter number and unit through command line (Unit should be either Meter or Centimeter).");
            return;
        }
        try {
            double number = Double.parseDouble(args[0]);
            String unit = args[1];
            if (unit.equals("Centimeter")) {
                double meter = number / 100;
                printMessage(number + " meters is equivalent to " + meter + " centimeter");
            } else if (unit.equals("Meter")) {
                double centimeter = number * 100;
                printMessage(number + " centimeters is equivalent to " + centimeter + " meter");
            } else {
                throw new UnitFormatException("Invalid unit. Please specify 'centimeter' or 'meter'.");
            }
        } catch (NumberFormatException e) {
            printMessage("Invalid number format. Please provide a valid number.");
        } catch (UnitFormatException e) {
            printMessage(e.getMessage());
        } catch (Exception e) {
            printMessage("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
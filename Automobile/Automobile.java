public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
        try {
            make = "";
            model = "";
            color = "";
            year = 0;
            mileage = 0;
        } catch (RuntimeException e) {
            throw new IllegalStateException("Failed to initialize automobile: " + e.getMessage(), e);
        }
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        try {
            validateVehicle(make, model, color, year, mileage);
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to create automobile: " + e.getMessage(), e);
        }
    }

    public String addNewVehicle(String make, String model, String color, int year, int mileage) {
        try {
            validateVehicle(make, model, color, year, mileage);
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully.";
        } catch (IllegalArgumentException e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    public String[] listVehicleInformation() {
        try {
            return new String[] {
                    "Make: " + make,
                    "Model: " + model,
                    "Color: " + color,
                    "Year: " + year,
                    "Mileage: " + mileage
            };
        } catch (RuntimeException e) {
            return new String[] {"Failed to list vehicle information: " + e.getMessage()};
        }
    }

    public String removeVehicle() {
        try {
            make = "";
            model = "";
            color = "";
            year = 0;
            mileage = 0;
            return "Vehicle removed successfully.";
        } catch (RuntimeException e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            validateVehicle(make, model, color, year, mileage);
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle updated successfully.";
        } catch (IllegalArgumentException e) {
            return "Failed to update vehicle: " + e.getMessage();
        }
    }

    private static void validateVehicle(String make, String model, String color, int year, int mileage) {
        try {
            if (make == null || make.trim().isEmpty()) {
                throw new IllegalArgumentException("Make cannot be blank.");
            }
            if (model == null || model.trim().isEmpty()) {
                throw new IllegalArgumentException("Model cannot be blank.");
            }
            if (color == null || color.trim().isEmpty()) {
                throw new IllegalArgumentException("Color cannot be blank.");
            }
            if (year <= 0) {
                throw new IllegalArgumentException("Year must be greater than zero.");
            }
            if (mileage < 0) {
                throw new IllegalArgumentException("Mileage cannot be negative.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid vehicle information: " + e.getMessage(), e);
        }
    }
}

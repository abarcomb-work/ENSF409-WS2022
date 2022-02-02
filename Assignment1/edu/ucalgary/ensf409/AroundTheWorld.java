package edu.ucalgary.ensf409;

/*
Copyright Ann Barcomb and Emily Marasco, 2021-2022
All rights reserved.
*/

/*
   INSTRUCTIONS: Implement all the members for which stubs are provided.

   You may not modify (change arguments, change permissions, etc) any of the
   stubs provided. You may only add to the code.

   You may modify class AroundTheWorld, which is included for testing purposes only.
   It will not be graded. 

   Include your name and student ID at the top of the file, as comments or
   documentation. 

   Other tips: 
   1. If you use the provided main() in AroundTheWorld.java, the output should
      match what is given in output.txt. When you check your output, be sure to
      use a method of comparison which will also identify differences in whitespace,
      such as 'diff' (available on Mac/Linux/Windows with Cygwin).
   2. You may assume that we will only test with valid data in the format
      shown in exampleData(), but we will not use the same data to test.
   3. You may add any additional methods and data that you like, provided
      this does not change how the program functions.
   5. The code can be completed using concepts introduced up to and including
      the day the assignment was released.
   6. You may assume that there will never be more than 20 trips.
      You may assume that trips will only occur in the years 2021, 2022,
      and 2023. They can occur in any month of the year.
   7. Any public method in the Itinerary and Trip classes may be evaluated.
*/


public class AroundTheWorld {
    public static void main(String[] args) {
        var data = exampleData();

        // Create a new Itinerary object. Order of listings is the same
        // as input data. Input data is always in order.
        var myItinerary = new Itinerary(data);

        System.out.println("** Demonstrate formatByArrival");
        System.out.println(myItinerary.formatByArrival());

        // Add a blank line before the next output - 
        // does not end with a newline character.
        System.out.println();

        // Retrieve the array of Trip objects from Itinerary
        var array = myItinerary.getTrips();

        System.out.println("** Demonstrate fmtString");
        System.out.println(array[0].fmtString("City", array[0].getCity()));
        System.out.println(Itinerary.fmtString("Key", "Value"));

        System.out.println("** Demonstrate formatTrip");
        String[] tmp = {"2023-07-10", "2023-08-11", "Vaduz", "Liechtenstein"};
        Trip aTrip = new Trip(tmp);
        System.out.println(aTrip.formatTrip());

        System.out.println("** Demonstrate getMonth");
        System.out.println(aTrip.getMonth(tmp[0]));

        System.out.println("** Demonstrate getYear");
        System.out.println(Trip.getYear(tmp[1]));

        System.out.println("** Demonstrate getters and setters");
        System.out.println();
	array[4].setDeparture("2023-01-10");
	array[4].setArrival("2023-01-10");
	System.out.println("--" + array[4].getArrival() + "--");
	System.out.println("--" + array[4].getDeparture() + "--");
	System.out.println("--" + array[4].getCity() + "--");
	System.out.println("--" + array[4].getCountry() + "--");

        System.out.println("** Demonstrate content of byDate");
	var dateArray = myItinerary.byDate();
	for (int i=0; i<dateArray.length; i++) { // i is years - 2021-2023 
		for (int j=0; j<dateArray[i].length; j++) { // j is months, 0-11
			System.out.printf("dateArray[%d][%d][%d] = %s\n", i,j,0,
			dateArray[i][j][0]);
		}
	}

    }

    // Each line is: arrival date, departure date, city, country/territory
    public static String[][] exampleData() {
        String[][] example = { 
            { "2021-12-15", "2021-12-31", "Nuuk", "Greenland" },
            { "2021-12-31", "2023-01-05", "Longyearbyen", "Svalbard" },
            { "2023-01-05", "2023-01-08", "Helsinki", "Finland" },
            { "2023-01-08", "2023-01-12", "Casablanca", "Morocco" },
            { "2023-01-12", "2023-01-15", "Istanbul", "Turkey" },
            { "2023-01-15", "2023-01-17", "Yerevan", "Armenia" },
            { "2023-01-17", "2023-01-18", "Tblisi", "Georgia" },
            { "2023-01-19", "2023-01-20", "Coimbatore", "India" }, 
            { "2023-01-20", "2023-01-27", "Ooty", "India" },
            { "2023-01-27", "2023-01-30", "Hyderabad", "India" },
            { "2023-01-31", "2023-02-05", "Seoul", "South Korea" },
            { "2023-02-05", "2023-02-07", "Jeju", "South Korea" },
            { "2023-02-07", "2023-02-08", "Seoul", "South Korea" },
            { "2023-02-08", "2023-02-08", "Tokyo", "Japan" }, 
            { "2023-02-08", "2023-02-15", "Osaka", "Japan" } 
        };
        return example;
    }
}

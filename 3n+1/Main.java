class Stuff implements Runnable {

    @Override
    public void run() {
        String line = Main.ReadLn(128);
        while (line != null) {
            process(line);
            line = Main.ReadLn(128);
        }
    }

    private void process(String line) {

        String[] data = line.split("\\s+");

        if (data.length == 2) {
            int low = Integer.parseInt(data[0]);
            int high = Integer.parseInt(data[1]);
				int[] cycles = new int[high-low+1];
                                int ind = 0;
				for (int i=low; i<high+1;i++){

					cycles[ind] =  cycle(i);
 					ind+=1;
				}


			System.out.println(low + " " + high + " " +  findMax(cycles));



        }

    }


   private int cycle(int n){
	   int count = 1;

      while (n!=1){

				  if (n%2==0){
					  n = n / 2;
					  count+=1;
				  }
				  else{
					  
					  n = (3*n) + 1;
					  count+=1;


				  }
					
 		} 

      return count;
   }

	public static int findMax(int[] array){
		int max_value = Integer.MIN_VALUE;

		for (int value: array) {
			if ( value > max_value ) {
				max_value = value;
			}


		}
		
		return max_value;

	}



		






}

// java program model from www.programming-challenges.com
class Main implements Runnable {
    static String ReadLn(int maxLength) { // utility function to read from
        // stdin, Provided by Programming-challenges, edit for style only
        byte line[] = new byte[maxLength];
        int length = 0;
        int input = -1;
        try {
            while (length < maxLength) { // Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n'))
                    break; // or untill end of line ninput
                line[length++] += input;
            }

            if ((input < 0) && (length == 0))
                return null; // eof
            return new String(line, 0, length);
        } catch (java.io.IOException e) {
            return null;
        }
    }

    public static void main(String args[]) { // entry point from OS
        Main myWork = new Main(); // Construct the bootloader
        myWork.run(); // execute
    }

    @Override
    public void run() {
        new Stuff().run();
    }

}

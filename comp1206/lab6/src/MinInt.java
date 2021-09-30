import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.*;

public class MinInt implements MinimumInArray{

    public static void main(String[] numbers){
        int[] arr = {24,52,74,9,34,23,64,34};
        MinInt minInt = new MinInt();
        System.out.println("Minimum is: " + minInt.findMin(arr));
    }

    public int findMin(int[] array){
        int smallest = array[0];
        int index = 1;
        if (array.length > index) {
            smallest = findMin(array, smallest, index);
        }
		return smallest;
    }

	public int findMin(int[] array, int smallest, int index) {
        if (array.length > index) {
            if (array[index] < smallest) {
                smallest = array[index];
            }
            index += 1;
            smallest = findMin(array, smallest, index);

        }
        return smallest;
    }
}
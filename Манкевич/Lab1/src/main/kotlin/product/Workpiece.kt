package product

class Workpiece(val name:String,private var shape:String="rough") {

    // function for call private method
    fun changeShapeRequest(shape: String){
        println("a u really wanna change the shape? Y/N")
        val option = readln();
        if(option == "Y" || option == "y" || option == "Да" || option == "да"){
            changeShape(shape);
        }else{
            println("Canceled");
         return;
        }
    }
    private fun changeShape(newShape: String){
         val oldShape:String=shape
         shape = newShape
         println("Shape of $name is changed from $oldShape on $newShape")

    }
}

class Product(private var isReady:Boolean=true){
    fun isReady(): Boolean {
        return isReady
    }
    fun setProductReady(ready: Boolean) {
        isReady = ready
        checkReadiness()
    }

    private fun checkReadiness(){
        if(isReady){
            println("Product is ready")
        }
        else{
            println("Product is unready")
        }
    }
}
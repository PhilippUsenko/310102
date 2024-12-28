abstract class Organ(open val _weight: Double?) {}

open class Head(weight: Double?) :Organ(weight){
    private var list_head: MutableList<Head> =mutableListOf()
    fun getValue(): MutableList<Head>{
        return list_head
    }
    fun setValue(obj: Head): Head
    {
        list_head.add(obj)
        return obj
    }
}

open class Body(weight: Double?) :Organ(weight){
    private var list_body: MutableList<Body> =mutableListOf()
    fun getValue(): MutableList<Body>{
        return list_body
    }
    fun setValue(obj: Body): Body
    {
        list_body.add(obj)
        return obj
    }
}
open class Organ_Head(weight: Double?) :Head(weight){}
open class Organ_Body(weight: Double?) :Body(weight){}

class Ear(weight: Double?, var earring: Boolean) :Organ_Head(weight){
    fun isEarring(): Boolean{
        return earring
    }
    fun Hear(_sound: String):String{
        println("Ухо слышит $_sound")
        return _sound
    }
}
class Nose(weight: Double?,private var shape: String) :Organ_Head(weight) {
    fun Sniff(_smell: String?): String? {
        println("Нос чувствует запах $_smell")
        return _smell
    }

    fun Itch(_itch: String): String {
        println("Нос чешеться от $_itch")
        return _itch
    }
}
class Brain(weight: Double?,private var kpd: Int) : Organ_Head(weight) {
    var temp_smell:String?=null
    fun Manage_Mouth(manage:Mouth):String?{
        println("Укажите пищу")
        var food: String?= readLine()
        var temp:String?=manage.Eat(food)
        return temp
    }
    fun Manage_Nose(_manage:Nose):String?{
        println("Введите запах")
        var _smell: String?= readLine()
        temp_smell=_smell
        var temp:String?=_manage.Sniff(_smell)
        return temp
    }
    fun getSound(func: (String) -> String, sound: String) {
        println("Ухо передало в мозг информацию о $sound")
    }

    fun getSmell() {
        println("Нос передал в мозг информацию о запахе $temp_smell")
    }

    fun getItch(func: (String) -> String, itch: String) {
        println("После чесания нос испытавает $itch")
    }
}

class Mouth(weight: Double?, var size: String) : Organ_Body(weight) {
    private fun Info():String? {
        println("Какие ощущения от еды?")
        var info:String?= readLine()
        return info
    }
    fun Eat(food: String?):String? {
        println("Идёт прием пищи $food")
        var _temp:String?=Info()
        println(_temp)
        return _temp
    }
    fun Speak(words: String){
        println(words)
    }
    private fun Transf(food: String?):String?{
        println("Еда поступила от рта к желудку")
        return food
    }
    fun Transfering(food: String?):String?{
        var temp:String?
        temp=Transf(food)
        return temp
    }
}

class Stomach(weight: Double?, private var volume: Double,var mouth:Mouth) : Organ_Body(weight) {
    private fun Digestion(_food:String?)
    {
        var food:String?=mouth.Transfering(_food)
        println("Желудок переварил $food")
    }
    fun getFood(func: (String?) -> String?, food: String) {
        var _food:String?=food
        println("Пища $food отправлена к желудку")
        Digestion(_food)
    }

}

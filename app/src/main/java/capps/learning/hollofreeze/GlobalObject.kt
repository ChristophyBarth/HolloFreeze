package capps.learning.hollofreeze

object GlobalCart {
    //Todo("Figure this")
    //Sealed class
    //Extension functions.
    //Lambda expressions and higher-order functions
    //Publishing to play store.

    val listOfItems = mutableListOf<Item>()

    fun addNewItem(newItem: Item) {
        var itemFound = false

        for (item in listOfItems) {
            if (item.name == newItem.name && item.description == newItem.description) {
                item.quantity = newItem.quantity!! + 1

                println("${item.name}'s new count is ${item.quantity}")
                itemFound = true
                break
            }
        }

        if (!itemFound) {
            newItem.quantity = 1
            listOfItems.add(newItem)

            println("${newItem.name} has been added to the list")
        }
    }
}
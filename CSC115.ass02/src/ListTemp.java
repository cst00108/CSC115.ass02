/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jason Donald
 */
public interface ListTemp {

	/**
	 * Inserts an item to into the list at postion index.
	 * All items after the new item will have their index position increased by one.
	 * For example, if <code>list</code> is a list of integers {1,2,3}, then
	 * <code>list.add(9,0)</code> will alter the list to contain {9,1,2,3} in 
	 * that order.
	 * @param item The object to add to the front of the list.
	 * @param index The index position for the new item.
	 * Note that the index position may be equal to the number of items, meaning that
	 * the item will be placed at the end of the list.
	 * @throws ListIndexOutOfBoundsException if the index is outside(0 &hellip; size).
	 */ 
	public void add(Medication item, int index);	
	
	/**
	 * Removes the item at the index position of the list.
	 * @param index The index number.
	 * @throws ListIndexOutOfBoundsException if the index is outside (0 &hellip; size-1).
	 */
	public void remove(int index);

	/**
 	 * Accesses the item by its position in the list.
 	 * @param index The index of the position.
 	 * @return The item at that index position.
	 * @throws ListIndexOutOfBoundsException if the index is outside (0 &hellip; size-1).
	 */ 
	public Medication get(int index);

	/**
	 * @return true if the list is empty, false otherwise.
 	 */
	public boolean isEmpty();

	/**
 	 * @return The number of items in the list.
	 */
	public int size();

	/**
	 * Determines if the equivalent item is in the list.
	 * If it is in the list, then the index location is returned.
	 * If it is not, then -1 is returned.
	 * @param item The item that is equivalent to the item we are looking for.
	 * @return The index position of the equivalent item or -1 if it is not in the list.
	 */
	public int find(Medication item);
	
	/**
 	 * Removes all the items from the list, resulting in an empty list.
	 */
	public void removeAll();

	/**
	 * Removes all matching items from the list.
	 * For example, if the list is made up of integers and contains {67,12,13,12},
	 * then <code>remove(12)</code>
	 * will alter the list to {67,13}.
	 * @param value The item that identies what to remove. 
	 *	Any item in the list that matches this item will be removed.
	 * 	Note that if no matching item can be found, then nothing is removed.
 	 */
	public void remove(Medication value);

	/**
 	 * A printout of the list is in the form:
	 * <code>List: {&lt;item1&gt;,
	 *	&lt;item2&gt;,
	 *	&hellip;,
	 *	&lt;last item&gt;}
	 * </code>
	 * where each item is the string returned by its <code>toString</code> method.
	 * Note that all the items can be listed on one line or placed on separate lines, depending on the
	 * aesthetics.
	 * An empty list is represented by <code>List: {}</code>
	 * @return The string representation of the list, formatted as above.
	 */
	public String toString();
}

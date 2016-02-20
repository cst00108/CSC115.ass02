/*
 * Name:      Jason Donald
 * ID:        V00861539
 * Date:      2006-02-13
 * Filename:  MedListRefBased.java
 * Details:   CSC115 Assignment 2
 */

/*
 * The MedListRefBased is a list that uses a doubly linked list as
 * the storage for its Medications.
 */
public class MedListRefBased implements List<Medication>{
	private MedicationNode<Medication> head;
	private MedicationNode<Medication> butt;
	private int size = 0;


	public void add(Medication item, int index) {
		//if isn't within items already added or added to the end
		if(!(isIndex(index) || size()==index)){ 
			throw new ListIndexOutOfBoundsException("Trying to add an index " +
					"which isn't there.");
		}
		
		MedicationNode<Medication> newbie = //create node
				new MedicationNode<Medication>(item);
		
		if(isEmpty()){ //start list
			butt = head = newbie;
		} else if(index == size){ //add to rear
			newbie.prev = butt;
			butt.next = newbie;
			butt = newbie;
		} else if(index == 0){ //add to start
			newbie.next = head;
			head.prev = newbie;
			head = newbie;
		} else { //add to the middle some place
			MedicationNode<Medication> insertBefore = getMedicationNode(index);
			MedicationNode<Medication> insertAfter = insertBefore.prev;
			
			//insert new Medication
			insertAfter.next = newbie;
			insertBefore.prev = newbie;
			newbie.next = insertBefore;
			newbie.prev = insertAfter;
		}
		
		size++;
	}
	
	/**
	 * To check if valid index.
	 * @param index To check.
	 * @return true if valid.
	 */
	private boolean isIndex(int index) {
		if(index < 0 || index >= size){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Get's the Medication node.
	 * @param getIndex The index of what to retrieve.
	 * @return  The Medication node or null if out of list bounds.
	 */
	private MedicationNode<Medication> getMedicationNode(int getIndex) {
		if(!isIndex(getIndex)){
			return null;
		}
		
		MedicationNode<Medication> toReturn;
		
		if(getIndex < size()/2){ //go from the head
			toReturn = head;
			
			for(int index=0; true; index++){ //go though untill matches
				if(index == getIndex){
					return toReturn;
				}
				
				toReturn = toReturn.next;
			}
		} else { //check from the rear
			toReturn = butt;
			
			for(int index=size-1; true; index--){ //go though untill matches
				if(index == getIndex){
					return toReturn;
				}
				
				toReturn = toReturn.prev;
			}
		}
	}

	public Medication get(int index) {
		//get the node containing Medication
		MedicationNode<Medication> toReturn = getMedicationNode(index);
		
		if(toReturn == null){
			throw new ListIndexOutOfBoundsException(
					"Couldn't retreave because index isn't there.");
		}
		
		return toReturn.item;
	}

	public boolean isEmpty() {
		if(butt == null){
			return true;
		}
		
		return false;
	}

	/**
	 * Get's the size of the list.
	 * @return The number of items in the list.
	 */
	public int size() {
		return size;
	}

	public int find(Medication item) {
		MedicationNode<Medication> checker = head;
		
		for(int index=0; checker!=null; index++){
			if(item.equals(checker.item)){
				return index;
			}
			
			checker = checker.next;
		}
		
		return -1;
	}

	public void removeAll() {
		butt = head = null;
		size = 0;
	}

	public void remove(int index) {
		if(!isIndex(index)){
			throw new ListIndexOutOfBoundsException(
					"Can't remove index which isn't there.");
		}
		
		if(size() == 1){ //if size of list is only 1, remove it 
			removeAll();
			
			return;
		} else if (index == 0){ //if start of list, remove it
			head = head.next;
			head.prev = null;
		} else if (index == size-1){ //if end of list, remove it
			butt = butt.prev;
			butt.next = null;
		} else { //remove from some place in the middle
			MedicationNode<Medication> remove = getMedicationNode(index);

			//put references around node to remove
			remove.prev.next = remove.next;
			remove.prev.next = remove.prev;
			
			//leave no evidence (leave for garbage collector)
			remove.next = null;
			remove.prev = null;
		}
		
		size--;
	}

	public void remove(Medication value) {
		int index = -1;
		
		while((index=find(value)) != -1){
			remove(index);
		}
	}
}

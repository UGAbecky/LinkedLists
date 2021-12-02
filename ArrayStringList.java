package cs1302.list;

import cs1302.listadt.StringList;

/**
 * This class contains a set of methods to manipulate the contents
 * of a {@code ArrayStringList} object.
 *
 */
public class ArrayStringList implements StringList {

    private int size;
    private String[] myList;

    /**
     * This is the default constructor of the class.
     */
    public ArrayStringList() {
        size = 0;
        myList = new String[20];
    } // ArrayStringList

    /**
     * This is the copy constructor, takes an {@code other} and creates an
     * {@code ArrayStringList} object with the same values as {@code other}.
     *
     * @param other is the {@code ArrayStringList} to be copied.
     */
    public ArrayStringList(StringList other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (other.size() == 0) { // default constructor
            size = 0;
            myList = new String[20];
        } else {
            myList = new String[other.size()];
            for (int i = 0; i < other.size(); i++) {
                myList[i] = other.get(i);
            } // for
        } // if
    } // ArrayStringList

    /**
     * returns the number of elements in the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    } // size

    /**
     * Checks if list has no elements.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        } // if
    } // isEmpty

    /**
     * Checks if list hast has any matching elements.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean contains(String o) {
        boolean check = false;
        if (o == null) { // starting if else on methods indicate exception handling
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(myList[i])) {
                    check = true;
                } // if
            } // for
            return check;
        } // if
    } // contains

    /**
     * Checks if list has any matching elements regardless of case.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean containsIgnoreCase(String o) {
        boolean check = false;
        if (o == null) {
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equalsIgnoreCase(myList[i])) {
                    check = true;
                } // if
            } // for
            return check;
        } // if
    } // containsIgnoreCase

    /**
     * Checks if list has this substring within.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean containsSubstring(String o) {
        boolean check = false;
        if (o == null) {
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < size; i++) {
                if (o.contains(this.get(i))) {
                    check = true;
                } // if
            } // for
            return check;
        } // if
    } // containsSubstring

    /**
     * Creates a free array from original list w/ elements in same order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String[] toArray() {
        String[] product = new String[this.size()];
        for (int i = 0; i < size; i++) {
            product[i] = myList[i];
        } // for
        return myList;
    } // toArray

    /**
     * Adds a string to the end of the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(String s) {
        boolean check;
        if (s == null) {
            check = false;
            throw new NullPointerException();
        } else if (s.length() == 0) {
            check = false;
            throw new IllegalArgumentException();
        } else {
            if (myList.length - size == 0) { // checks if list is empty
                // creates temp array to of new length to later copy into an updated myList
                String[] temp = new String[myList.length + 10];
                for (int i = 0; i < size; i++) {
                    temp[i] = myList[i];
                } // for
                myList = new String[temp.length];
                for (int i = 0; i < size; i++) {
                    myList[i] = temp[i];
                } // for
            } // if
            myList[size] = s; // adds the string s
            size++;
            check = true;
        } // if
        return check;
    } // add

    /**
     * Adds the contents of list in original order at the end.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(StringList s1) {
        boolean check = false;
        if (s1 == null) {
            throw new NullPointerException();
        } else if (s1.size() != 0) {
            // checks if list would be empty by completion
            if (myList.length - (this.size() + s1.size()) <= 0) {
                // creates temp array to of new length to later copy into an updated myList
                String[] temp = new String[myList.length + s1.size() + 10];
                for (int i = 0; i < size; i++) {
                    temp[i] = myList[i];
                } // for
                myList = new String[temp.length];
                for (int i = 0; i < size; i++) {
                    myList[i] = temp[i];
                } // for
            } // if
            int ogSize = this.size();
            for (int i = 0; i < s1.size(); i++) { // adds values at end of array
                myList[i + ogSize] = s1.get(i);
                size++;
            } // for
            check = true;
        } // if
        return check;
    } // add

    /**
     * Adds string at a specific point in the list shifting elements to the right.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String s) {
        boolean check = false;
        if (s == null) {
            throw new NullPointerException();
        } else if (s.length() == 0) {
            throw new IllegalArgumentException();
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (myList.length - size == 0) { // checks if list is empty
                // creates temp array to of new length to later copy into an updated myList
                String[] temp = new String[myList.length + 10];
                for (int i = 0; i < size; i++) {
                    temp[i] = myList[i];
                } // for
                myList = new String[temp.length];
                for (int i = 0; i < size; i++) {
                    myList[i] = temp[i];
                } // for
            } // if
            String container = myList[index];
            myList[index] = s;
            size++;
            // holds next index so the array can copy proceeding values after changing value @ index
            for (int i = index + 1; i < size; i++) {
                myList[i] = container;
                if ( i < size) {
                    container = myList[i + 1];
                }
            } // for
            check = true;
        } // if
        return check;
    } // add

     /**
     * Inserts ordered list in a specific point shifting other elements to the right.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, StringList s1) {
        boolean check = false;
        if (s1 == null) {
            throw new NullPointerException();
        }  else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (s1.size() != 0) {
            // checks if list would be empty by completion
            if (myList.length - (this.size() + s1.size())  <= 0 ) {
                // creates temp array to of new length to later copy into an updated myList
                String[] temp = new String[myList.length + s1.size() + 10];
                for (int i = 0; i < size; i++) {
                    temp[i] = myList[i];
                } // for
                myList = new String[temp.length];
                for (int i = 0; i < size; i++) {
                    myList[i] = temp[i];
                } // for
            } // if
            String[] copy = new String[this.size() - index];
            for (int i = 0; i < copy.length; i++) { // copies area after addding s1
                copy[i] = myList[index + i];
            } //for
            for (int i = 0; i < s1.size(); i++) { // adds in values of s1
                myList[index + i] = s1.get(i);
                size++;
            } // for
            for (int i = index + s1.size(); i < (this.size() - index); i++) {
                int counter = 0; // adds in old values of copy
                myList[i] = copy[counter];
                counter++;
            } // for
            check = true;
        } // if
        return check;
    } // add

    /**
     * Removes item and shifts everything else to the left.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            String contents = myList[index];
            for (int i = index; i < size; i++) {
                int counter = 0;
                myList[i] = myList[i + counter]; // shifts everything from index to the left one
                counter++;
            } // for
            size--;
            return contents;
        } // if
    } // remove

    /**
     * Returns string at index supplied.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return myList[index];
        } // if
    } // get

    /**
     * Replaces the string at supplied index.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String set(int index, String s) {
        if (s == null) {
            throw new NullPointerException();
        } else if (s.length() == 0) {
            throw new IllegalArgumentException();
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            String og = myList[index];
            myList[index] = s;
            return og;
        } // if
    } // set

    /**
     * Returns index of 1st instance of string or -1 if undiscovered.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int indexOf(String s) {
        if (s == null) {
            throw new NullPointerException();
        } else if (s.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            int location = -1; // sets default as unfound
            for (int i = 0; i < size; i++) {
                if (s.equals(myList[i]) ) {
                    location = i; // if a location match is found sets index of it and ends loop
                    i = size;
                } // if
            } // for
            return location;
        }  // if
    } // indexOf

    /**
     * Returns index of 1st instance regardless of case or -1 if undiscovered.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public int indexOfIgnoreCase(String s) {
        if (s == null) {
            throw new NullPointerException();
        } else if (s.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            int location = -1; // sets default as unfound
            for (int i = 0; i < size; i++) {
                if (s.equalsIgnoreCase(myList[i]) ) {
                    location = i; // if a location match is found sets index of it and ends loop
                    i = size;
                } // if
            } // for
            return location;
        }  // if
    } // indexOfIgnoreCase

    /**
     * Removes everything from the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        myList = new String[20];
    } // clear

    /**
     * Builds a stringlist without any duplicate strings.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList distinct() {
        ArrayStringList distinct = new ArrayStringList(this);
        for (int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                // checks if values are equivalent and removes them from the list
                if ( (distinct.get(i).contains(distinct.get(j))) && (j != i) ) {
                    distinct.remove(j);
                    j = 0;
                } // if
            } // for
        } // for
        return distinct;
    } // distinct

    /**
     * Builds a stringlist with the contents in the reverse order.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList reverse() {
        ArrayStringList reverse = new ArrayStringList(this);
        int counter = 0;
        for (int i = (this.size() - 1); i >= 0; i--) { // iterates backwards to set reversed values
            reverse.set(counter, this.get(i));
            counter++;
        } // for
        return reverse;
    } // reverse

    /**
     * Concatenates all elements of the list with supplied seperators.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String sep) {
        String product = "";
        if (size != 0) {
            product = myList[0]; // starts w/ first value
            for (int i = 1; i < size; i++) {
                product += sep + myList[i];
            } //for
        } // if
        return product;
    } // makeString

    /**
     * Creates a new string list with the selected indices as bounds.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList splice(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) { // checks index bouundaries
            throw new IndexOutOfBoundsException();
        } else if (fromIndex == toIndex) { // checks for equivalent indices
            ArrayStringList splice = new ArrayStringList();
            return splice;
        } else {
            ArrayStringList splice = new ArrayStringList(this);
            for (int i = 0; i < fromIndex - 1; i++) { // removes before fromIndex
                splice.remove(i);
            } // for
            for (int i = toIndex; i < this.size(); i++) { // removes after toIndex
                splice.remove(i);
            }
            return splice;
        } // if
    } // splice

} // ArrayStringList

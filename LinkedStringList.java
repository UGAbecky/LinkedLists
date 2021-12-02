package cs1302.list;

import cs1302.listadt.StringList;
import cs1302.listadt.StringList.Node;

/**
 * This class contains methods to manipulate the values of a {@code LinkedStringList} object.
 */
public class LinkedStringList implements StringList {

    private int size;
    private StringList.Node head;

    /**
     * This is the default constructor of the class.
     */
    public LinkedStringList() {
        size = 0;
        head = new StringList.Node();
    } // LinkedStringList

    /**
     * This is the copy constructor, takes an {@code other} and creates an
     * {@code LinkedStringList} object with the same values as {@code other}.
     *
     * @param other is the {@code LinkedStringList} to be copied.
     */
    public LinkedStringList(StringList other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (other.size() == 0) { // default constructor
            size = 0;
            head = new StringList.Node();
        } else {
            size = other.size(); // take size of other and place head at its starting point
            head = new StringList.Node(other.get(0));
            StringList.Node counter = new StringList.Node("", head);
            counter = counter.getNext();
            for (int i = 1; i < size; i++) { // sets following values in list
                counter.setNext(new StringList.Node(other.get(i)));
                if (counter.getNext() != null) {
                    counter = counter.getNext();
                } // if
            } // for
        } // if
    } // LinkedStringList

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
        if (o == null) { // starting if else on methods indicate exception handling
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            boolean check = false;
            StringList.Node checker = new StringList.Node("", head);
            checker = checker.getNext();
            for (int i = 0; i < size; i++) {
                if (checker.getStr().equals(o)) {
                    check = true; // if found updates to true
                } // if
                if (checker.getNext() != null) {
                    checker = checker.getNext();
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
        if (o == null) { // starting if else on methods indicate exception handling
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            StringList.Node checker = new StringList.Node("", head);
            checker = checker.getNext();
            for (int i = 0; i < size; i++) {
                if (checker.getStr().equalsIgnoreCase(o)) {
                    check = true;
                } // if
                if (checker.getNext() != null) {
                    checker = checker.getNext();
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
        if (o == null) { // starting if else on methods indicate exception handling
            throw new NullPointerException();
        } else if (o.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            StringList.Node checker = new StringList.Node("", head);
            checker = checker.getNext();
            for (int i = 0; i < size; i++) {
                if (checker.getStr().contains(o)) {
                    check = true;
                } // if
                if (checker.getNext() != null) {
                    checker = checker.getNext();
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
        for (int i = 0; i < this.size(); i++) {
            product[i] = this.get(i); // loops through to get correct array values
        } // for
        return product;
    } // toArray

    /**
     * Adds a string to the end of the list.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(String s) {
        boolean check = false;
        if (s == null) {
            throw new NullPointerException();
        } else if (s.length() == 0) {
            throw new IllegalArgumentException();
        } else if (size != 0) {
            StringList.Node position = new StringList.Node("", head);
            for (int i = 0; i < size; i++) {
                position = position.getNext(); // moves position to end
            } // for
            position.setNext(new StringList.Node(s)); // assigns new value and updates size
            size++;
            check = true;
        } else {
            head.setStr(s);
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
            StringList.Node otherHead = new StringList.Node(s1.get(0)); // other head for place
            StringList.Node position = new StringList.Node("", otherHead); // tail
            position = position.getNext();
            for (int i = 1; i < s1.size(); i++) {
                position.setNext(new StringList.Node(s1.get(i)));
                position = position.getNext();
            } // for
            if (this.size() == 0) {
                head = new StringList.Node("", otherHead);
                head = head.getNext(); // sets the otherhead to this head
                size = s1.size(); // updates size
                check = true;
            } else {
                StringList.Node tail = new StringList.Node("", head);
                for (int i = 0; i < size; i++) {
                    tail = tail.getNext();
                } // for
                tail.setNext(new StringList.Node()); // places other list where it belongs
                tail.setNext(otherHead);
                size += s1.size();
                check = true;
            } // if
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
        } else if (index != 0) {
            StringList.Node posAfter = new StringList.Node("", head);
            for (int i = 0; i < index + 1; i++) {
                posAfter = posAfter.getNext(); // finds position after insertion
            } // for
            StringList.Node pos = new StringList.Node(s, posAfter); // sets node before after to s
            StringList.Node posBefore = new StringList.Node("", head);
            for (int i = 0; i < index; i++) {
                posBefore = posBefore.getNext();
            } // for
            posBefore.setNext(pos); // sets before to the new added node
            size++;
            check = true;
        } else {
            StringList.Node newHead = new StringList.Node("", head);
            newHead = newHead.getNext();
            head = new StringList.Node(s, newHead); // sets head as s
            size++;
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
            if (index == 0) {
                LinkedStringList otherList = new LinkedStringList(s1);
                // construct head and tail for s1
                StringList.Node otherHead = otherList.head;
                StringList.Node otherTail = new StringList.Node("", otherHead);
                for (int i = 0; i < s1.size(); i++) {
                    otherTail = otherTail.getNext(); // locate tail
                } // for
                StringList.Node holder = head;
                otherTail.setNext(holder);
                head = otherHead; // update w/ new head
                size = size + s1.size();
            } else {
                LinkedStringList otherList = new LinkedStringList(s1);
                StringList.Node otherHead = otherList.head;
                StringList.Node otherTail = new StringList.Node("", otherHead);
                for (int i = 0; i < s1.size(); i++) {
                    otherTail = otherTail.getNext();
                } // for
                // creates positions before and after to work like other add(index)
                StringList.Node posBefore = new StringList.Node("", head);
                StringList.Node posAfter = new StringList.Node("", head);
                for (int i = 0; i < index; i++) {
                    posBefore = posBefore.getNext();
                } // for
                for (int i = 0; i < index + 1; i++) {
                    posAfter = posAfter.getNext();
                } // for
                otherTail.setNext(posAfter);
                posBefore.setNext(otherHead);
                size += s1.size();
            } // if
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
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            // finds node before and after then links the two
            String contents = this.get(index);
            StringList.Node posBefore = new StringList.Node("", head);
            StringList.Node posAfter = new StringList.Node("", head);
            for (int i = 0; i < index; i++) {
                posBefore = posBefore.getNext();
            } // for
            for (int i = -1; i < index; i++) {
                posAfter = posAfter.getNext();
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            String contents;
            StringList.Node position = new StringList.Node("", head);
            position = position.getNext();
            for (int i = 0; i < index; i++) {
                position = position.getNext(); // finds value
            } // for
            contents = position.getStr();
            return contents;
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
            String og = this.get(index); // for return
            StringList.Node position = new StringList.Node("", head);
            for (int i = -1; i < index; i++) {
                position = position.getNext(); // finds value
            } // for
            position.setStr(s);
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
            int index = -1; // -1 for failure
            for (int i = 0; i < size; i++) {
                if (this.get(i).equals(s)) {
                    index = i; // updated to index if found
                } // if
            } // for
            return index;
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
            int index = -1;
            for (int i = 0; i < size; i++) { // searches through list
                if (this.get(i).equalsIgnoreCase(s)) {
                    index = i;
                } // if
            } // for
            return index;
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
        head = new StringList.Node();
    } // clear

    /**
     * Builds a stringlist without any duplicate strings.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList distinct() {
        LinkedStringList distinct = new LinkedStringList(this);
        for (int i = 0; i < distinct.size(); i++) {
            for ( int j = 0; j < distinct.size(); j++) {
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
        LinkedStringList reverse = new LinkedStringList(this);
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
            StringList.Node position = new StringList.Node("", head);
            for (int i = 0; i < size - 1; i++) { // iterates through and adds necessary valyes
                position = position.getNext();
                product += position.getStr() + sep;
            } // for
            position = position.getNext();
            product += position.getStr(); // final step
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
            LinkedStringList splice = new LinkedStringList();
            return splice;
        } else {
            LinkedStringList splice = new LinkedStringList(this);
            for (int i = 0; i < fromIndex - 1; i++) { // removes before fromIndex
                splice.remove(i);
            } // for
            for (int i = toIndex; i < this.size(); i++) { // removes after toIndex
                splice.remove(i);
            }
            return splice;
        } // if
    } // splice

} // LinkedStringList

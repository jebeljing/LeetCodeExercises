package package300;

import base.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jingshanyin on 1/15/17.
 * 341. Flatten Nested List Iterator
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */
public class FlattenNestedListIterator {

}

class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    int index = 0;
    List<Integer> list = new ArrayList<>();

    private void helper(NestedInteger nestedInteger, List<Integer> list) {
        if (nestedInteger.isInteger()) {
            list.add(nestedInteger.getInteger());
        } else {
            List<NestedInteger> tempList = nestedInteger.getList();
            for (int i = 0; i < tempList.size(); i++) {
                helper(tempList.get(i), list);
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        for (int i = 0; i < nestedList.size(); i++) {
            helper(nestedList.get(i), list);
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}



/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
import java.util.Arrays;
import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {
    private List<I> collection;
    private Integer itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int items = itemCount();
        int pagecount = 0;
        while (items > itemsPerPage) {
            items -= itemsPerPage;
            pagecount++;
        }
        if (items > 0) {
            pagecount++;
        }
        return pagecount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < pageCount() -1) {
            return itemsPerPage;
        } else if (pageIndex == pageCount() -1) {
            return itemCount() - (itemsPerPage * (pageCount() - 1));
        } else {
            return -1;
        }
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > itemCount() || itemIndex <= 0) {
            return -1;
        }
        if (itemIndex <= itemsPerPage) {
            return 0;
        } else {
            int pageIndex = -1;
            while (itemIndex > itemsPerPage) {
                itemIndex -= itemsPerPage;
                pageIndex++;
            }
            if (itemIndex > 0) {
                pageIndex++;
            }
            return pageIndex;
        }
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount()); // should == 2
        System.out.println(helper.itemCount()); // should == 6
        System.out.println(helper.pageItemCount(0)); // should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

// pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); // should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); // should == 0
        System.out.println(helper.pageIndex(20)); // should == -1
        System.out.println(helper.pageIndex(-10)); // should == -1
    }
}

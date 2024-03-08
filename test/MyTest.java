import dp.CanJump;
import dp.DP;
import graph.BFS;
import graph.DFS;
import graph.Dijkstra;
import greedy.Greedy;
import leetcode.*;
import lib_use.*;
import org.junit.Test;
import search.Binary_Search;
import sort.Merge;
import sort.Quick;
import strings.KMP;

public class MyTest {
    @Test
    public void test() {
        System.out.println("Test");
    }
    @Test
    public void testSort() {

    }
    @Test
    public void test_use_array() {
        Use_array useArray = new Use_array();
    }
    @Test
    public void test_obj_val() {
        Val_object val_object = new Val_object();
    }
    @Test
    public void test_use_list() {
        Use_list useList = new Use_list();
    }
    @Test
    public void test_use_map() {
        Use_map useMap = new Use_map();
    }
    @Test
    public void test_use_set() {
        Use_set useSet = new Use_set();
    }
    @Test
    public void test_use_convert() {
        Convert convert = new Convert();
    }
    @Test
    public void test_use_queue() {
        Use_queue useQueue = new Use_queue();
    }
    @Test
    public void test_use_stack() {
        Use_stack useStack = new Use_stack();
    }
    @Test
    public void test_use_collection() {
        Use_collection useCollection = new Use_collection();
    }
    @Test
    public void test_binary_search() {
        Binary_Search binarySearch = new Binary_Search();
    }
    @Test
    public void test_quick_sort() {
        Quick quick = new Quick();
    }
    @Test
    public void test_merge_sort() {
        Merge merge = new Merge();
    }
    @Test
    public void test_greedy(){
        Greedy greedy = new Greedy();
    }
    @Test
    public void test_DFS() {
        DFS dfs = new DFS(5);
    }
    @Test
    public void test_BFS() {
        BFS bfs = new BFS(5);
    }
    @Test
    public void test_DP() {
        DP dp = new DP();
    }
    @Test
    public void test_lru() {
        LRU lru = new LRU(4);
        lru.put(2, 3);
        lru.put(3,1);
        lru.put(6,5);
        lru.put(8,1010);
        lru.put(5, 29);
        System.out.println(lru.get(3)); // 1
        System.out.println(lru.get(2)); // -1
        lru.put(33, 2);
        System.out.println(lru.get(3)); // 结果应该是 1， 但输出 -1。 说明是根据插入顺序顺序删除的
        System.out.println(lru.get(6));
    }
    @Test
    public void test_kmp() {
        KMP kmp = new KMP();
    }
    @Test
    public void test_heap() {
        Heap heap = new Heap();
    }
    @Test
    public void test_dijkstra() {
        Dijkstra dijkstra = new Dijkstra();
    }
    @Test
    public void test_can_jump() {
        CanJump canJump = new CanJump();
    }
    @Test
    public void test_slide_win() {
        SlideWin slideWin = new SlideWin();
    }
    @Test
    public void test_valid_bracket() {
        ValidBracket validBracket = new ValidBracket();
    }
    @Test
    public void test_merge_intervals() {
        MergeIntervals mergeIntervals = new MergeIntervals();
    }
    @Test
    public void test_rotate_matrix() {
        RotateMatrix rotateMatrix = new RotateMatrix();
    }
    @Test
    public void test_Palindrome() {
        Palindrome palindrome = new Palindrome();
    }
    @Test
    public void test_IslandCount() {
        IslandCount islandCount = new IslandCount();
    }
}

600. Smallest Rectangle Enclosing Black Pixels
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Example
Example 1:

Input：["0010","0110","0100"]，x=0，y=2
Output：6
Explanation：
The upper left coordinate of the matrix is (0,1), and the lower right coordinate is (2,2).
Example 2:

Input：["1110","1100","0000","0000"], x = 0, y = 1
Output：6
Explanation：
The upper left coordinate of the matrix is (0, 0), and the lower right coordinate is (1,2).

//brute force. O(mn)
public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        int ans=0;
        if(image.length==0 || image[0].length==0){
            return ans;
        }
        
        int[] low=new int[]{image.length-1,image[0].length-1};
        int[] high=new int[]{0,0};
        
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]=='1'){
                    if(i<low[0]){
                        low[0]=i;
                    }
                    if(j<low[1]){
                        low[1]=j;
                    }
                    if(i>high[0]){
                        high[0]=i;
                    }
                    if(j>high[1]){
                        high[1]=j;
                    }
                }
            }
        }
        ans=(high[0]-low[0]+1)*(high[1]-low[1]+1);
        return ans;
    }
}

//binary search and brute force combine. O(mlogn+nlogm)
public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        int ans=0;
        if(image.length==0 || image[0].length==0){
            return ans;
        }
        
        int left=findleft(image,y);
        int right=findright(image,y);
        int top=findtop(image,x);
        int bottom=findbottom(image,x);
        ans=(right-left+1)*(bottom-top+1);
        return ans;
    }
    private boolean isemptycol(char[][] image,int col){
        for(int i=0;i<image.length;i++){
            if(image[i][col]=='1'){
                return false;
            }
        }
        return true;
    }
    private boolean isemptyrow(char[][] image,int row){
        for(int i=0;i<image[0].length;i++){
            if(image[row][i]=='1'){
                return false;
            }
        }
        return true;
    }
    private int findleft(char[][] image,int y){
        int start=0;
        int end=y;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(isemptycol(image,mid)){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(isemptycol(image,start)){
            return end;
        }
        else{
            return start;
        }
    }
    private int findright(char[][] image,int y){
        int start=y;
        int end=image[0].length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(isemptycol(image,mid)){
                end=mid;
            }
            else{
                start=mid;
            }
        }
        if(isemptycol(image,end)){
            return start;
        }
        else{
            return end;
        }
    }
    private int findtop(char[][] image,int x){
        int start=0;
        int end=x;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(isemptyrow(image,mid)){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(isemptyrow(image,start)){
            return end;
        }
        else{
            return start;
        }
    }
    private int findbottom(char[][] image,int x){
        int start=x;
        int end=image.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(isemptyrow(image,mid)){
                end=mid;
            }
            else{
                start=mid;
            }
        }
        if(isemptyrow(image,end)){
            return start;
        }
        else{
            return end;
        }
    }
}
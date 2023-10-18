class Solution {
public:
    void insertion(vector<int> &nums){
        if(nums.size() == 0){
            return;
        }
        for(int i=1;i<nums.size();i++){
            int key = nums[i];
            int k = i-1;
            for(;k>=0;k--){
                if(key<nums[k]){
                   nums[k+1] = nums[k];
                }else{
                    break;
                }
            }
            nums[k+1] = key;
        }
    }
    void heapify(vector<int> &nums,int index){
        int i = index;
        int li = index;
        int n = nums.size();

        while(i<n){
            int left = (2*i)+1;
            int right = (2*i)+2;

            if(left < n && (nums[left]>nums[li])){
                li = left;
            }
            if(right < n && (nums[right] > nums[li])){
                li = right;
            }

            if(li == i){
                break;
            }

            swap(nums[li],nums[i]);
            i = li;
        }

    }
    void heapify1(vector<int> &nums,int index, int last){
        
        int i = index;
        int li = index;
        int n = last;

       // cout<<n<<" last index"<<endl;

        while(i<=n){
            int left = (2*i)+1;
            int right = (2*i)+2;

            if(left < n && (nums[left]>nums[li])){
                li = left;
            }
            if(right < n && (nums[right] > nums[li])){
                li = right;
            }

            if(li == i){
                break;
            }

            swap(nums[li],nums[i]);
            i = li;
        }
        //   for(auto i:nums){
        //     cout<<i<<" ";
        // }
        //   cout<<endl;

    }
    void heapsort(vector<int> &nums){
        // convert to max heap
        //heapify

        int n = nums.size();
        int start = (n/2) - 1;

        for(int i = start;i>=0;i--){
            heapify(nums,i);
        }

    //   for(auto i:nums){
    //         cout<<i<<" ";
    //     }
    //       cout<<endl;      

        int lastIndex = n-1;
        for(int i=0;i<n;i++){
             swap(nums[0],nums[lastIndex]);
             heapify1(nums,0,lastIndex--);
        }
        
    }
    vector<int> sortArray(vector<int>& nums) {
        //insertion(nums);
        heapsort(nums);
        return nums;
    }
};

#include<iostream>
#include<vector>
#include<functional>
using namespace std;
int main()
{
    vector<int> candidates={2,3,6,7};
    int target=7;
    vector<vector<int>> ans;
    vector<int> path;
    function<void(int, int)> dfs=[&](int i,int left)
    {
        if(left==0)
        {
            ans.push_back(path);
            return;
        }
        if(i==candidates.size()||left<0)
        {
            return;
        }
        //unchoose
        dfs(i+1,left);
        //choose
        path.push_back(candidates[i]);
        dfs(i,left-candidates[i]);
        path.pop_back();
    };
    dfs(0,target);
    for(auto x:ans)
    {
        for(auto y:x)
        {
            cout<<y;
        }
        cout<<endl;
    }
}
#include<iostream>
using namespace std;
int main()
{
    static int i,j,k;
    cin>>i>>j;
    cout<<"i:"<<i<<" j:"<<j<<endl;
    k=i+j;
    cout<<"k:"<<k<<endl;
    if(1)
    {
        static int k;
        k=i-k;
        cout<<"k:"<<k<<endl;
    }
    cout<<"k:"<<k<<endl;
}
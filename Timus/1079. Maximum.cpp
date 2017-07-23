// The solution of the problem was written by Izaron
// Date: 20:13:47   30 Jan 2015
// Execution time: 0.015

// Please do not copy-paste the solution.
// Try to understand what is happening here and write your own.

#include <string>
#include <sstream>
#include <cstring>
#include <sstream>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdio.h>
#include <fstream>
#include <ctime>
#include <cmath>
#include <math.h>
#include <set>
#include <map>
#include <list>
#include <iomanip>
#include <cstdio>
#include <algorithm>
using namespace std;

#define pp system("pause");
#define ct double ttme = clock()
#define p_ct cout << (clock() - ttme) / CLOCKS_PER_SEC << endl
#define all(c) (c).begin(),(c).end()
#define fft ifstream fin("input.txt"); ofstream fout("output.txt")
#define fft_c FILE *fin, *fout
#define fft_c_open fin = fopen("input.txt","r"); fout = fopen("output.txt","w")
#define fft_c_cl fclose(fin); fclose(fout)
#define pii pair<ll,ll>
#define pff pair<float,float>
#define piii pair<int,pair<int,int>>
#define M_PI 3.14159265358979323846
#define mem0(m) memset((m), 0, sizeof(m));
#define memb(m) memset((m), false, sizeof(m));
#define memi(m) memset((m), 0, sizeof(m));
#define REP(i,n) for(int i = 0; i < (int)(n); i++)
typedef unsigned long long ull;
typedef signed long long ll;
const int INF = 1e8;
const int MAXM = 100000007;
const int MAX = 1e7;
const int des = 10000;


int main() {
    ios_base::sync_with_stdio(0);

    ll mass[100005], maxi[100005];
    mass[0] = 0;
    mass[1] = 1;

    for(int i = 2; i <= 100000; i++) {
        if(i % 2 == 0) {
            mass[i] = mass[i / 2];
        } else {
            mass[i] = mass[i / 2] + mass[i / 2 + 1];
        }
    }

    maxi[0] = 0;
    for(int i = 1; i <= 100000; i++) {
        maxi[i] = max(maxi[i - 1], mass[i]);
    }

    int i;
    while(cin >> i) {
        if(i == 0)
            break;
        cout << maxi[i] << endl;
    }
}

#include<iostream>
#include<string>
using namespace std;
void print(int arr[3][3]){
	for(int i = 0 ; i < 3 ; i++){
		cout<<"------------"<<endl;
		cout<<arr[i][0]<<" | "<<arr[i][1]<<" | "<<arr[i][2]<<endl;
	}
		cout<<"------------"<<endl;
}
int check(int tmp,int arr[3][3]){
	for(int i = 0 ; i < 3 ; i++){
		if(arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1) return tmp;
		if(arr[i][0] == 2 && arr[i][1] == 2 && arr[i][2] == 2) return tmp;
	}
	for(int i = 0 ; i < 3 ; i++){	
		if(arr[0][i] == 1 && arr[0][i] == 1 && arr[2][i] == 1) return tmp;
		if(arr[0][i] == 2 && arr[0][i] == 2 && arr[2][i] == 2) return tmp;
	}
	if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return tmp;
	if(arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) return tmp;
	return -1;
}
int main(){
	bool run = true;
	int tmp = 0;
	int arr[3][3],x,y;
	for(int i = 0 ; i < 3 ; i++){
		for(int j = 0 ; j < 3 ; j++){
			arr[i][j] = 0;
		}
	}
	print(arr);
	while(run){
		if(tmp % 2 == 0){
			cout<<"Nguoi choi thu 1 nhap : ";
			cin>>x>>y;
			if(x == 9 && y == 9){
				run = false;
			}else{
				while(true){
					if(arr[x][y] != 1&& arr[x][y] != 2 && x < 3 && y < 3){
						arr[x][y] = 1;
						print(arr);
						break;
					}
					cout<<"Moi Nguoi choi 1 nhap lai : ";
					cin>>x>>y;
				}
				if(tmp == check(tmp,arr)){
					cout<<"Nguoi choi 1 da chien thang"<<endl;
					run = false;
				}
			}
		}
		else{
			cout<<"Nguoi choi thu 2 nhap : ";
			cin>>x>>y;
			if(x == 9 && y == 9){
				run = false;
			}else{
				while(true){
					if(arr[x][y] != 1 && arr[x][y] != 2 && x < 3 && y < 3){
						arr[x][y] = 2;	
						print(arr);
						break;
					}
					cout<<"Moi Nguoi choi 2 nhap lai : ";
					cin>>x>>y;
	
				}
				if(tmp == check(tmp,arr)){
					cout<<"Nguoi choi 2 da chien thang"<<endl;
					run = false;
				}
			}
		}
		tmp += 1;
	}
	return 0;
}

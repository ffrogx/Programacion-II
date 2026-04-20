#include <iostream>
using namespace std;

int main() {
    char L[5] = {'2','3','4','5','6'};
    char x;

    cout << "Ingrese un caracter: ";
    cin >> x;

    for (int i = 0; i < 5; i++) {
        if (L[i] == x) {
            L[i] = '*';
        }
    }

    // Mostrar resultado
    for (int i = 0; i < 5; i++) {
        cout << L[i] << " ";
    }

    return 0;
}
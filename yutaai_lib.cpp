#include <vector>
#include <cmath>
extern "C" double multiply(double a, double b){ return a*b; }
extern "C" double relu(double x){ return x>0?x:0; }

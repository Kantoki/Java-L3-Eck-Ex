# -*- coding: utf-8 -*-

import numpy as np
import random
import matplotlib.pyplot as plt
 
def generateData(mu, sig, data, nb):
    for i in range(0,nb-1):
        data.append(np.random.normal(mu,sig))
    return data;
 
def generateYData(dataX, dataE, dataY, nb, B0, B1):
    for i in range(0,nb-1):
        dataY.append(B0+B1*dataX[i]+dataE[i])
    return dataY
    
def calculMoyenne(data, nb):
    ave = 0
    for i in range(0,nb-1):
        ave += data[i]
    return ave/nb;
    
def calculVariance(data, nb, ave):
    var = 0
    for i in range(0, nb - 1):
        # var += np.power(data[i]-ave,2)
        var += data[i]**2 - ave**2
    return var/nb;

def calculCovariance(dataX, dataY, aveX, aveY, nb):
    cov = 0
    for i in range(0, nb - 1):
        cov += (dataX[i]-aveX)*(dataY[i]-aveY)
    return cov/nb;
    
def calculCoeffCorrelation(dataX, dataY, aveX, aveY, sigX, sigY, nb):   
    cov = calculCovariance(dataX, dataY, aveX, aveY, nb)
    return cov / (sigX*sigY);
 
# Définission des données pour X, E et Y
nbData = 100
muX = 10
sigX = 4
muE = 0
sigE = 1
B0 =1
B1 = -2
dataX = []
dataE = []
dataY = []
aveX = 0
aveY = 0
#Génération des données pour X, E et Y
dataX = generateData(muX, sigX, dataX, nbData)
dataE = generateData(muE, sigE, dataE, nbData)
dataY = generateYData(dataX, dataE, dataY, nbData, B0, B1)
 
aveX = calculMoyenne(dataX, nbData)
aveY = calculMoyenne(dataY, nbData)

varX = calculVariance(dataX, nbData,aveX)
varY = calculVariance(dataY, nbData,aveY)

plt.scatter(dataX,dataY,s=50)
 
plt.title('Nuage de points')
plt.xlabel('x')
plt.ylabel('y')
plt.savefig('nuagesExo1.png')
plt.show()
print(aveY);
print(varY); 
print(aveX);
print(varX); 
 
print('------- Coefficient de correlation --------');
print(calculCoeffCorrelation(dataX, dataY, aveX, aveY, np.sqrt(varX), np.sqrt(varY), nbData));
print("On obtient un coefficient de corrélation proche de -1 : cela montre une forte liaison entre X et Y mais la relation linéaire entre les deux caractères est décroissante (relation linéaire négative) (les variables varient dans le sens contraire))")
    
#Calcul paramètres de la droite de régression

def calculB1Chapeau(dataX, dataY, aveX, aveY, nb):
    cov = calculCovariance(dataX, dataY, aveX, aveY, nb)
    B1Chapeau = cov / sigX
    return B1Chapeau;

def calculB0Chapeau(dataX, dataY, aveX, aveY, nb, B1Chapeau):
    B1Chapeau = calculB1Chapeau(dataX, dataY, aveX, aveY, nb)
    B0Chapeau = aveY - (B1Chapeau * aveX)
    return B0Chapeau;

B1Chapeau = calculB1Chapeau(dataX, dataY, aveX, aveY, nbData);
print("B1", B1Chapeau)
print("La droite étant décroissante on a b1 < 0")

B0Chapeau = calculB0Chapeau(dataX, dataY, aveX, aveY, nbData, B1Chapeau)
print("B0", B0Chapeau)


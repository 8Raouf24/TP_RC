from __future__ import print_function
from pyds import MassFunction
from itertools import product

"""
Dans le cadre du NASA SPACEAPP CHALLENGE 2021, les participants sont invités à choisir une problématique parmis les 21 thèmes proposés.
L'énoncé d'un des challenges est l'utilisation de satellite  pour la prédiction d'éventuels catastrophes naturelles.
Salim et Raouf, deux étudiants en Informatique Visuelle ont proposé un outil de prédiction faisant appel à la vision par ordinateur via des réseaux de neuronnes.
Néanmoins, le choix de l'architecture neuronal à utiliser fut la pomme de discord entre les deux experts .
    -Selon Salim, nous allons avoir besoin à 60% d'un Residal Neural Network,à 10 % d'un Convolutional Neural Network, et à 10% un Recursive Neural Network. 
    -Selon Raouf, nous devrions utiliser un  Residal Neural Network ou un Convolutional Neural Network à  80%.
 """
print("Our Omega : {Residual Neural Network : Re, Convolutional Neural Network: C, Recursive Neural Network : RNN")
print('=== Création des fonctions de masses de croyance ===')
m1 = MassFunction([({'Re'}, 0.7), ({'C'}, 0.15), ('R', 0.15)])
m2 = MassFunction([({'Re','R'}, 0.8),({'C'}, 0.2)])
print(m1)
print(m2)

print('\n=== Croyance, Plausibilité, et Communalité===')

print("Croyance")
print('bel_1 =', m1.bel(),'\n') # entire belief function
print('bel_2 =', m2.bel(),'\n')

print("Plausibilité")
print('pl_1 =', m1.pl(),'\n') 
print('pl_2 =', m2.pl(),'\n')

print("Communalité")
print('q_1 =', m1.q(),'\n') 
print('q_2 =', m2.q(),'\n')

print('Combinaison conjonctive (non normalise) et regle de combinaison de Dempster-Schefer ')
print('Combinaison de Dempster-Shafer de m_1 et m_2 = ',m1 & m2)
print('Combinaison conjonctive (non normalisé) de m_1 et m_2 =', m1.combine_conjunctive(m2, normalization=False))
print('\n=== Degres de conflit ===')
print('Le degres de conflit entre m_1 et m_2 =', m1.conflict(m2))
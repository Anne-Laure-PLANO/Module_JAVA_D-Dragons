# 🐉 Donjons et Dragons - Jeu Java

## 🎯 Objectif
Traverse un plateau, combats des ennemis, récupère des équipements et potions, et survie jusqu’à la fin !  
Jeu **tour par tour** joué via la console.

---

## 🗺️ Plateau de jeu
- 64 cases  
- Types de cases :  
  - 🟦 Vide  
  - 👾 Ennemi  
  - 🎁 Caisse surprise (armes, sorts, potions)

---

## 🧙‍♂️ Personnages

| Type      | Attributs    | Équipements autorisés       |
|-----------|-------------|----------------------------|
| Guerrier  | PV, attaque | Massue, Épée               |
| Magicien  | PV, attaque | Éclair, Boule de feu       |

---

## ⚔️ Équipements & Potions

### Armes (Guerrier)
- Massue : +3 attaque  
- Épée : +5 attaque  

### Sorts (Magicien)
- Éclair : +2 attaque  
- Boule de feu : +7 attaque  

### Potions (Tous)
- Potion : +2 PV  
- Grande potion : +5 PV  

**Améliorations personnelles :**
- Sac à dos pour stocker les potions  
- Lorsqu’on trouve une potion : **boire ou stocker**

---

## 👹 Ennemis
- Combats au contact, PV persistants  
- Disparaissent si PV = 0  

**Amélioration personnelle :** certains monstres peuvent fuir, mais pas s’ils peuvent tuer le joueur en un coup. En cas de fuite, sont replacés sur le chemin du héros.

---

## 🎲 Déroulement du jeu
1. Choix du personnage et nom  
2. Lancer de dé → déplacement  
3. Selon la case :  
   - 🟦 Vide → tour suivant  
   - 🎁 Caisse → récupère objet si compatible ou potion : **boire / stocker**  
   - 👾 Ennemi → **combat ou tentative de fuite**  

**Amélioration personnelle :** la fuite devant un ennemi est **aléatoire** : si échec, le monstre attaque et le joueur doit choisir à nouveau son action

---

## 🛡️ Règles des combats
- Attaque selon équipement  
- Ennemi riposte si vivant  
- PV des ennemis persistent d’un tour à l’autre  

**Améliorations personnelles :** choix tactique renforcé avec fuite possible et monstres qui peuvent fuir selon situation

---

## 🏆 Fin de partie
- **Victoire** : atteindre la fin du plateau  
- **Défaite** : PV du joueur = 0

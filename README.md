# Assignment 1 – Grid Game Extension

## Author
Arjun Sankar Hariharasuthan

## Overview
This project builds on Week 5 grid classwork and turns it into a small interactive game. The grid now has different terrain types (Water, Grass, Sand) and items (Fish, Bone, Seed) that actors can collect.

Actors (Cat, Dog, Bird) are polygons that move according to terrain rules and can carry items in an inventory. Clicking a cell moves the current actor if the cell is passable and picks up any compatible item.

This project shows use of inheritance, interfaces, and generics.

---

## Features

- Clicking a cell moves the actor in turn: Cat → Dog → Bird.  
- Multiple terrain types: Grass, Sand, Water.  
- Water cells are randomly placed for variety; Sand follows a pattern.  
- Items on the grid: Fish, Bone, Seed.  
- Custom movement rules:  
  - Cat and Dog cannot enter water.  
  - Bird can move over any terrain.  
- Items can only be collected by the right actor:  
  - Cat → Fish, Dog → Bone, Bird → Seed.  
- Points are awarded for picking up items and shown in real-time.  
- Item colors for clarity: Fish – Magenta, Bone – Orange, Seed – Cyan.

---

## Inheritance & Interfaces

- **Inheritance:** `Actor` is an abstract base class. Cat, Dog, and Bird extend Actor and override `canEnter` to define terrain-specific movement rules.  
- **Interfaces:** `Terrain` is implemented by Grass, Sand, and Water, each defining `getMovementCost()` and `getColor()`.  

This design allows easy extension:  

- Adding a new actor only requires creating a new subclass of `Actor`.  
- Adding a new terrain type only requires implementing the `Terrain` interface.

---

## Generics

- `Inventory<T>` is a generic class used to store items in a type-safe way.  
- Each actor has an `Inventory<Item>`, allowing collection of compatible items without type casting.  
- The points system interacts with the inventory: points are awarded when an actor collects a compatible item.  

This demonstrates genuine use of generics beyond standard collections.

---

## Creativity

- Random water cells make movement more interesting.  
- Inventory system ensures type safety.  
- Points system adds immediate feedback.  
- Fully interactive: clicking respects rules, updates visually, and collects items.

---

## How to Compile & Run

1. Make sure Java 11 or 21 is installed.  
2. Open a terminal in the project folder.  
3. Compile all files:  



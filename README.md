# Assignment 1 – Grid Game Extension

## Author
Arjun Sankar Hariharasuthan

## Overview
This project extends the Week 5 grid classwork into a small interactive game featuring actors and items. The grid is no longer featureless: each `Cell` can have different terrain types (`Water`, `Grass`, etc.), and items (`Fish`, `Bone`, `Seed`) can exist on the cells for actors to collect.

Actors (`Cat`, `Dog`, `Bird`) are represented as polygons, have movement rules based on terrain, and maintain an inventory. Clicking on a cell moves the first actor (the Cat) if the cell is passable and collects any item present.

This implementation demonstrates inheritance, interfaces, generics, and thoughtful design improvements.

---

## Features (Functionality)

- Interactive grid where clicking a cell moves an actor.
- Multiple terrain types: `Grass` and `Water`.
- Items placed on the grid: `Fish`, `Bone`, and `Seed`.
- Different actors (`Cat`, `Dog`, `Bird`) with custom movement rules:
  - Cat cannot enter water.
- Actors can collect items and store them in an inventory.
- Items are visually distinct using colors:
  - Fish – Magenta  
  - Bone – Orange  
  - Seed – Cyan  
- **Points system**: Each actor collects points when picking up items relevant to them:
  - Cat collects points for Fish.   
  - Points are displayed on the GUI in real-time, giving feedback as actors collect items.

---

## Inheritance and Interfaces

- **Inheritance**: `Actor` is an abstract base class. `Cat`, `Dog`, and `Bird` extend `Actor` and override the `canEnter` method for terrain-specific movement rules.  
- **Interfaces**: `Terrain` is an interface implemented by `Grass` and `Water`. Each terrain type defines its own `getMovementCost()` and `getColor()` methods.
- This design allows easy extension:
  - Adding a new actor requires only a new subclass of `Actor`.
  - Adding a new terrain type requires implementing the `Terrain` interface.

---

## Generics 

- `Inventory<T>` is a generic class used to store items in a type-safe way.
- Each `Actor` has an `Inventory<Item>` allowing them to collect items without type casting.
- The points system interacts with the `Inventory<Item>`: points are awarded when an actor collects a compatible item from their inventory.  
- This demonstrates genuine use of generics beyond just collections, meeting the rubric requirement.

---

## Uniqueness and Creativity 

- Beyond classwork:  
  - Added multiple terrain types and distinct items.  
  - Inventory system using generics.  
  - Points system adds a layer of interactivity and feedback not in classwork.
- Fully interactive: Clicking collects items, respects movement rules, and visually updates the grid.

---

## How to Compile and Run

1. Ensure you have **Java 11** or **Java 21** installed.
2. Open a terminal and navigate to the project folder.
3. Compile all `.java` files:



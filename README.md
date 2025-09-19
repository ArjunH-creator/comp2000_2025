# Assignment 1 – Grid Game Extension

## Author
Arjun Sankar Hariharasuthan

## Overview
This project builds upon Week 5 grid classwork and expands it into a little interactive game with actors and items. The grid is no longer featureless, any `Cell` may have different types of terrain (`Water`, `Grass`, etc.), and items (`Fish`, `Bone`, `Seed`) can be on the cells for actors to collect.

Actors (`Cat`, `Dog`, `Bird`) are represented as polygons, can move based on terrain, and maintain an inventory. Clicking in a cell moves the first actor (the Cat) if the cell is traversable and collects any object present.

This implementation demonstrates inheritance, interfaces, generics, and thoughtful design improvements.

---

## Features (Functionality)

-Interactive grid where clicking a cell moves an actor.
-Multiple terrain types: Grass and Water.
-Items placed on the grid: Fish, Bone, and Seed.
-Actors (Cat, Dog, Bird) with custom movement rules:
-Cat cannot enter water.
-Item collection: Clicking on a cell lets the Cat collect Fish only.
-Points system: The Cat earns points when collecting Fish.
-Points are displayed on the GUI in real-time, giving immediate feedback.
-Items are visually distinct using colors:
-Fish – Magenta
-Bone – Orange
-Seed – Cyan

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



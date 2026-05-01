# 🧩 Design Patterns — Learning Repository

> A personal journey through the world of software design patterns — documented, implemented, and organized for reference and growth.

---

## 📖 About This Repository

This repository is a hands-on learning log of the classic **Gang of Four (GoF)** design patterns and beyond. Each pattern is explored with:

- 📝 A clear explanation of the **intent and problem it solves**
- 🏗️ A real-world **analogy** to build intuition
- 💻 A **code implementation** with clean examples
- ✅ Notes on **when to use** and **when to avoid** the pattern

Whether you're revisiting fundamentals or encountering these patterns for the first time, this repo serves as both a study guide and a practical reference.

---

## 🗂️ Repository Structure

```
design-patterns/
│
├── creational/
│   ├── singleton/
│   ├── factory-method/
│   ├── abstract-factory/
│   ├── builder/
│   └── prototype/
│
├── structural/
│   ├── adapter/
│   ├── bridge/
│   ├── composite/
│   ├── decorator/
│   ├── facade/
│   ├── flyweight/
│   └── proxy/
│
├── behavioral/
│   ├── chain-of-responsibility/
│   ├── command/
│   ├── iterator/
│   ├── mediator/
│   ├── memento/
│   ├── observer/
│   ├── state/
│   ├── strategy/
│   ├── template-method/
│   └── visitor/
│
└── README.md
```

---

## 🌐 What Are Design Patterns?

Design patterns are **reusable solutions to commonly occurring problems** in software design. They are not finished code, but rather **templates or blueprints** that guide how to solve a problem in a flexible and maintainable way.

The concept was popularized by the **"Gang of Four" (GoF)** — Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides — in their landmark book *Design Patterns: Elements of Reusable Object-Oriented Software* (1994).

Design patterns are grouped into **three major categories** based on the kind of problem they address:

---

## 🏭 1. Creational Patterns

> **"How objects are created"**

Creational patterns deal with **object creation mechanisms**. They aim to create objects in a manner suitable to the situation, promoting flexibility and reuse while hiding the instantiation logic from the client.

| Pattern | Intent |
|---|---|
| **Singleton** | Ensures a class has only **one instance** and provides a global access point to it. |
| **Factory Method** | Defines an interface for creating an object, but lets **subclasses decide** which class to instantiate. |
| **Abstract Factory** | Provides an interface for creating **families of related objects** without specifying their concrete classes. |
| **Builder** | Separates the **construction of a complex object** from its representation, allowing the same process to produce different results. |
| **Prototype** | Creates new objects by **cloning an existing object** (the prototype), avoiding the cost of re-initialization. |

### 💡 When to think Creational?
When you find yourself writing complex `new` statements, managing object lifecycles, or needing to decouple object creation from its usage — reach for a creational pattern.

---

## 🏗️ 2. Structural Patterns

> **"How objects are composed and related"**

Structural patterns deal with **object composition** — how classes and objects are assembled into larger structures. They simplify the design by identifying simple ways to realize relationships between entities.

| Pattern | Intent |
|---|---|
| **Adapter** | Converts the interface of a class into another interface the client expects. Acts as a **bridge between incompatible interfaces**. |
| **Bridge** | **Decouples an abstraction from its implementation** so the two can vary independently. |
| **Composite** | Composes objects into **tree structures** to represent part-whole hierarchies, letting clients treat individual objects and compositions uniformly. |
| **Decorator** | Attaches **additional responsibilities to an object dynamically**, providing a flexible alternative to subclassing. |
| **Facade** | Provides a **simplified interface** to a complex subsystem, making it easier to use. |
| **Flyweight** | Uses sharing to efficiently support a **large number of fine-grained objects** by storing common state externally. |
| **Proxy** | Provides a **surrogate or placeholder** for another object to control access to it. |

### 💡 When to think Structural?
When you need to combine or wrap classes to form larger, more functional systems — or when working with legacy code that needs adapting — structural patterns come to the rescue.

---

## 🔄 3. Behavioral Patterns

> **"How objects communicate and interact"**

Behavioral patterns are concerned with **algorithms and the assignment of responsibilities** between objects. They define how objects interact and communicate in a way that increases flexibility.

| Pattern | Intent |
|---|---|
| **Chain of Responsibility** | Passes a request along a **chain of handlers**, where each handler decides to process it or pass it on. |
| **Command** | Encapsulates a request as an object, allowing you to **parameterize clients** with different requests, queue or log requests, and support undoable operations. |
| **Iterator** | Provides a way to **sequentially access elements** of a collection without exposing its underlying structure. |
| **Mediator** | Defines an object that **encapsulates how objects interact**, promoting loose coupling by keeping objects from referring to each other explicitly. |
| **Memento** | Captures and externalizes an object's **internal state** so it can be restored later, without violating encapsulation. |
| **Observer** | Defines a **one-to-many dependency** between objects so when one object changes state, all its dependents are notified automatically. |
| **State** | Allows an object to **alter its behavior when its internal state changes**, appearing to change its class. |
| **Strategy** | Defines a family of algorithms, encapsulates each one, and makes them **interchangeable** at runtime. |
| **Template Method** | Defines the **skeleton of an algorithm** in a base class, deferring some steps to subclasses without changing the algorithm's structure. |
| **Visitor** | Lets you **add further operations to objects** without modifying them, by separating the algorithm from the object structure. |

### 💡 When to think Behavioral?
When you're dealing with complex control flows, tight coupling between communicating objects, or algorithms that need to vary independently from the clients that use them — behavioral patterns offer clarity and flexibility.

---

## 📊 Patterns at a Glance

```
Design Patterns
│
├── Creational (5)   — Object creation & instantiation
│   ├── Singleton
│   ├── Factory Method
│   ├── Abstract Factory
│   ├── Builder
│   └── Prototype
│
├── Structural (7)   — Object composition & relationships
│   ├── Adapter
│   ├── Bridge
│   ├── Composite
│   ├── Decorator
│   ├── Facade
│   ├── Flyweight
│   └── Proxy
│
└── Behavioral (10)  — Object communication & responsibility
    ├── Chain of Responsibility
    ├── Command
    ├── Iterator
    ├── Mediator
    ├── Memento
    ├── Observer
    ├── State
    ├── Strategy
    ├── Template Method
    └── Visitor
```

---

## 🚀 Progress Tracker

| Pattern | Category | Status |
|---|---|---|
| Singleton | Creational | ⬜ Not Started |
| Factory Method | Creational | ⬜ Not Started |
| Abstract Factory | Creational | ⬜ Not Started |
| Builder | Creational | ⬜ Not Started |
| Prototype | Creational | ⬜ Not Started |
| Adapter | Structural | ⬜ Not Started |
| Bridge | Structural | ⬜ Not Started |
| Composite | Structural | ⬜ Not Started |
| Decorator | Structural | ⬜ Not Started |
| Facade | Structural | ⬜ Not Started |
| Flyweight | Structural | ⬜ Not Started |
| Proxy | Structural | ⬜ Not Started |
| Chain of Responsibility | Behavioral | ⬜ Not Started |
| Command | Behavioral | ⬜ Not Started |
| Iterator | Behavioral | ⬜ Not Started |
| Mediator | Behavioral | ⬜ Not Started |
| Memento | Behavioral | ⬜ Not Started |
| Observer | Behavioral | ⬜ Not Started |
| State | Behavioral | ⬜ Not Started |
| Strategy | Behavioral | ⬜ Not Started |
| Template Method | Behavioral | ⬜ Not Started |
| Visitor | Behavioral | ⬜ Not Started |

> Update status to: ⬜ Not Started → 🔄 In Progress → ✅ Done

---

## 📚 References & Further Reading

- 📘 *Design Patterns: Elements of Reusable Object-Oriented Software* — GoF (1994)
- 🌐 [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)
- 🌐 [SourceMaking — Design Patterns](https://sourcemaking.com/design_patterns)
- 📘 *Head First Design Patterns* — Freeman & Robson

---

## 🙌 Author - Prasanna Kumar Ganesula

**Learning in Progress** — built pattern by pattern, commit by commit.

> *"Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem."* — Christopher Alexander
# Builder
When construction gets a little too complicated. <br>
When piecewise object construction is complicated, provide an API for doing it succinctly.
## Motivation
1. Some objects are simple and can be created in a single constructor call.
2. Other objects require a lot of ceremony to create
3. Having an object with 10 constructor arguments is not productive.
4. Instead, opt for piecewise construction.
5. Builder provides an API for constructing an object step-by-step.

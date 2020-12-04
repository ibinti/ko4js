(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlinx-coroutines-core'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlinx-coroutines-core'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'ibinti'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'ibinti'.");
    }if (typeof this['kotlinx-coroutines-core'] === 'undefined') {
      throw new Error("Error loading module 'ibinti'. Its dependency 'kotlinx-coroutines-core' was not found. Please, check whether 'kotlinx-coroutines-core' is loaded prior to 'ibinti'.");
    }root.ibinti = factory(typeof ibinti === 'undefined' ? {} : ibinti, kotlin, this['kotlinx-coroutines-core']);
  }
}(this, function (_, Kotlin, $module$kotlinx_coroutines_core) {
  'use strict';
  var trimIndent = Kotlin.kotlin.text.trimIndent_pdl1vz$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var COROUTINE_SUSPENDED = Kotlin.kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED;
  var CoroutineImpl = Kotlin.kotlin.coroutines.CoroutineImpl;
  var throwCCE = Kotlin.throwCCE;
  var await_0 = $module$kotlinx_coroutines_core.kotlinx.coroutines.await_t11jrl$;
  var coroutines = $module$kotlinx_coroutines_core.kotlinx.coroutines;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var L5000 = Kotlin.Long.fromInt(5000);
  var delay = $module$kotlinx_coroutines_core.kotlinx.coroutines.delay_s8cxhz$;
  var L6000 = Kotlin.Long.fromInt(6000);
  var async = $module$kotlinx_coroutines_core.kotlinx.coroutines.async_pda6u4$;
  var Unit = Kotlin.kotlin.Unit;
  var toString = Kotlin.toString;
  var Throwable = Error;
  var trimMargin = Kotlin.kotlin.text.trimMargin_rjktp$;
  function main() {
    println(trimIndent('\n        \n        welcome to ibinti world!'));
    express_server();
  }
  function printjo(jo) {
    var msg = JSON.stringify(jo);
    println(msg);
  }
  function pawait(promise, continuation) {
    var tmp$;
    return await_0(Kotlin.isType(tmp$ = promise, Promise) ? tmp$ : throwCCE(), continuation);
  }
  function express_server$lambda$lambda$lambda$ObjectLiteral() {
  }
  express_server$lambda$lambda$lambda$ObjectLiteral.$metadata$ = {
    kind: Kind_CLASS,
    interfaces: []
  };
  function Coroutine$express_server$lambda$lambda$lambda$x_something_deep(continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 1;
  }
  Coroutine$express_server$lambda$lambda$lambda$x_something_deep.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda$x_something_deep.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda$x_something_deep.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda$x_something_deep;
  Coroutine$express_server$lambda$lambda$lambda$x_something_deep.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = delay(L5000, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return 5000;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda$x_something_deep(continuation_0, suspended) {
    var instance = new Coroutine$express_server$lambda$lambda$lambda$x_something_deep(continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  }
  function Coroutine$express_server$lambda$lambda$lambda$y_something_deep(continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.exceptionState_0 = 1;
  }
  Coroutine$express_server$lambda$lambda$lambda$y_something_deep.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda$y_something_deep.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda$y_something_deep.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda$y_something_deep;
  Coroutine$express_server$lambda$lambda$lambda$y_something_deep.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = delay(L6000, this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return 6000;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda$y_something_deep(continuation_0, suspended) {
    var instance = new Coroutine$express_server$lambda$lambda$lambda$y_something_deep(continuation_0);
    if (suspended)
      return instance;
    else
      return instance.doResume(null);
  }
  function Coroutine$express_server$lambda$lambda$lambda$lambda(closure$x_something_deep_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$x_something_deep = closure$x_something_deep_0;
  }
  Coroutine$express_server$lambda$lambda$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda$lambda.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda$lambda;
  Coroutine$express_server$lambda$lambda$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$x_something_deep(this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda$lambda(closure$x_something_deep_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$express_server$lambda$lambda$lambda$lambda(closure$x_something_deep_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$express_server$lambda$lambda$lambda$lambda_0(closure$y_something_deep_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$y_something_deep = closure$y_something_deep_0;
  }
  Coroutine$express_server$lambda$lambda$lambda$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda$lambda_0.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda$lambda_0;
  Coroutine$express_server$lambda$lambda$lambda$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.state_0 = 2;
            this.result_0 = this.local$closure$y_something_deep(this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            return this.result_0;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda$lambda_0(closure$y_something_deep_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$express_server$lambda$lambda$lambda$lambda_0(closure$y_something_deep_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function Coroutine$express_server$lambda$lambda$lambda(closure$res_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$res = closure$res_0;
    this.local$jo = void 0;
    this.local$y = void 0;
  }
  Coroutine$express_server$lambda$lambda$lambda.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda;
  Coroutine$express_server$lambda$lambda$lambda.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.local$jo = new express_server$lambda$lambda$lambda$ObjectLiteral();
            this.local$jo.hello = 'welcome to ibinti world!';
            var x_something_deep = express_server$lambda$lambda$lambda$x_something_deep;
            var y_something_deep = express_server$lambda$lambda$lambda$y_something_deep;
            var x = async(coroutines.GlobalScope, void 0, void 0, express_server$lambda$lambda$lambda$lambda(x_something_deep));
            this.local$y = async(coroutines.GlobalScope, void 0, void 0, express_server$lambda$lambda$lambda$lambda_0(y_something_deep));
            this.local$jo.before = Date();
            this.state_0 = 2;
            this.result_0 = x.await(this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            throw this.exception_0;
          case 2:
            this.local$jo.x = this.result_0;
            this.state_0 = 3;
            this.result_0 = this.local$y.await(this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 3:
            this.local$jo.y = this.result_0;
            this.local$jo.after = Date();
            this.local$jo.message = 'this will be shown on the browser after 6 seconds, not 11 seconds. can you tell the difference?';
            this.local$closure$res.send(this.local$jo);
            return printjo(this.local$jo), Unit;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda(closure$res_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$express_server$lambda$lambda$lambda(closure$res_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function express_server$lambda$lambda(req, res) {
    return async(coroutines.GlobalScope, void 0, void 0, express_server$lambda$lambda$lambda(res));
  }
  function express_server$lambda$lambda_0(req, res) {
    res.send(req.params);
    printjo(req.params);
    return Unit;
  }
  function express_server$lambda$lambda$lambda$lambda_1(response) {
    return response.text();
  }
  function express_server$lambda$lambda$lambda$lambda_2(closure$res) {
    return function (body) {
      closure$res.statusCode = 200;
      closure$res.setHeader('Content-Type', 'text/html');
      return closure$res.send(body);
    };
  }
  function express_server$lambda$lambda$lambda$lambda_3(err) {
    println('err: ' + err.message.toString());
    return Unit;
  }
  function Coroutine$express_server$lambda$lambda$lambda_0(closure$fetch_0, closure$res_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 1;
    this.local$closure$fetch = closure$fetch_0;
    this.local$closure$res = closure$res_0;
  }
  Coroutine$express_server$lambda$lambda$lambda_0.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda_0.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda_0.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda_0;
  Coroutine$express_server$lambda$lambda$lambda_0.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            return this.local$closure$fetch('https://ibinti.com/ko4js').then(express_server$lambda$lambda$lambda$lambda_1).then(express_server$lambda$lambda$lambda$lambda_2(this.local$closure$res)).catch(express_server$lambda$lambda$lambda$lambda_3);
          case 1:
            throw this.exception_0;
          default:this.state_0 = 1;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 1) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda_0(closure$fetch_0, closure$res_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$express_server$lambda$lambda$lambda_0(closure$fetch_0, closure$res_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function express_server$lambda$lambda_1(closure$fetch) {
    return function (req, res) {
      return async(coroutines.GlobalScope, void 0, void 0, express_server$lambda$lambda$lambda_0(closure$fetch, res));
    };
  }
  function Coroutine$express_server$lambda$lambda$lambda_1(closure$fetch_0, closure$res_0, $receiver_0, controller, continuation_0) {
    CoroutineImpl.call(this, continuation_0);
    this.$controller = controller;
    this.exceptionState_0 = 6;
    this.local$closure$fetch = closure$fetch_0;
    this.local$closure$res = closure$res_0;
  }
  Coroutine$express_server$lambda$lambda$lambda_1.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: null,
    interfaces: [CoroutineImpl]
  };
  Coroutine$express_server$lambda$lambda$lambda_1.prototype = Object.create(CoroutineImpl.prototype);
  Coroutine$express_server$lambda$lambda$lambda_1.prototype.constructor = Coroutine$express_server$lambda$lambda$lambda_1;
  Coroutine$express_server$lambda$lambda$lambda_1.prototype.doResume = function () {
    do
      try {
        switch (this.state_0) {
          case 0:
            this.exceptionState_0 = 3;
            this.state_0 = 1;
            this.result_0 = pawait(this.local$closure$fetch('https://ibinti.com/ko4js'), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 1:
            var response = this.result_0;
            this.state_0 = 2;
            this.result_0 = pawait(response.text(), this);
            if (this.result_0 === COROUTINE_SUSPENDED)
              return COROUTINE_SUSPENDED;
            continue;
          case 2:
            var body = this.result_0;
            this.local$closure$res.statusCode = 200;
            this.local$closure$res.setHeader('Content-Type', 'text/html');
            return this.local$closure$res.send(body);
          case 3:
            this.exceptionState_0 = 6;
            var t = this.exception_0;
            if (Kotlin.isType(t, Throwable)) {
              return println('err: ' + toString(t.message)), Unit;
            } else {
              throw t;
            }

          case 4:
            this.state_0 = 5;
            continue;
          case 5:
            return;
          case 6:
            throw this.exception_0;
          default:this.state_0 = 6;
            throw new Error('State Machine Unreachable execution');
        }
      } catch (e) {
        if (this.state_0 === 6) {
          this.exceptionState_0 = this.state_0;
          throw e;
        } else {
          this.state_0 = this.exceptionState_0;
          this.exception_0 = e;
        }
      }
     while (true);
  };
  function express_server$lambda$lambda$lambda_1(closure$fetch_0, closure$res_0) {
    return function ($receiver_0, continuation_0, suspended) {
      var instance = new Coroutine$express_server$lambda$lambda$lambda_1(closure$fetch_0, closure$res_0, $receiver_0, this, continuation_0);
      if (suspended)
        return instance;
      else
        return instance.doResume(null);
    };
  }
  function express_server$lambda$lambda_2(closure$fetch) {
    return function (req, res) {
      return async(coroutines.GlobalScope, void 0, void 0, express_server$lambda$lambda$lambda_1(closure$fetch, res));
    };
  }
  function express_server$lambda$lambda_3() {
    println(trimMargin(' \n        |nodejs express listening on port 2020\n        |\n        |open following urls with a web browser one bye one\n        |1. http://localhost:2020\n        |2. http://localhost:2020/user/999/book/588\n        |3. http://localhost:2020/fetch\n        |4. http://localhost:2020/pawait\n        | \n    '));
    return Unit;
  }
  function express_server$lambda() {
    var express = require('express');
    var fetch = require('node-fetch');
    var app = express();
    var port = 2020;
    app.get('/', express_server$lambda$lambda);
    app.get('/user/:user_id/book/:book_id', express_server$lambda$lambda_0);
    app.get('/fetch', express_server$lambda$lambda_1(fetch));
    app.get('/pawait', express_server$lambda$lambda_2(fetch));
    return app.listen(port, express_server$lambda$lambda_3);
  }
  var express_server;
  _.main = main;
  _.printjo_za3rmp$ = printjo;
  _.pawait_za3rmp$ = pawait;
  Object.defineProperty(_, 'express_server', {
    get: function () {
      return express_server;
    }
  });
  express_server = express_server$lambda;
  main();
  Kotlin.defineModule('ibinti', _);
  return _;
}));

//# sourceMappingURL=ibinti.js.map

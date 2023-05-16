import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:self_start_background/self_start_background.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String phoneModel = 'Unknown';

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text(phoneModel),
              MaterialButton(
                  onPressed: () async{
                    var getPhoneModel = await SelfStartBackground.getPhoneModel;
                    setState(() {
                      phoneModel = getPhoneModel;
                    });
                  },
                child: const Text("getPhoneModel"),
              )
            ],
          )
        ),
      ),
    );
  }
}

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
                color: Colors.blue,
                textColor: Colors.white,
                onPressed: () async {
                  var getPhoneModel = await SelfStartBackground.getPhoneModel;
                  var val = await getPhoneModel.value();
                  setState(() {
                    phoneModel = val;
                  });
                },
                child: const Text("getPhoneModel"),
              ),
              MaterialButton(
                color: Colors.blue,
                textColor: Colors.white,
                onPressed: () async {
                  await SelfStartBackground.openSelfStartSetting;
                },
                child: const Text("openSelfStartSetting"),
              ),
              MaterialButton(
                color: Colors.blue,
                textColor: Colors.white,
                shape: const RoundedRectangleBorder(
                  side: BorderSide.none,
                  borderRadius: BorderRadius.all(Radius.circular(50.0)),
                ),
                onPressed: () async {
                  await SelfStartBackground.openBackgroundSetting;
                },
                child: const Text("openBackgroundSetting"),
              )
            ],
          ),
        ),
      ),
    );
  }
}

import { Injectable } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Country} from "../model/Country";

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  countryForm: FormGroup = new FormGroup({
    countryCode: new FormControl(null, Validators.required),
    incomeLevel: new FormControl(0),
    region: new FormControl(0),
    lendingType: new FormControl(0)
  })

  constructor(private http: HttpClient) { }

  getCountryExplore(country: Country){
    console.log(country.countryCode+" / "+country.incomeLevel);
    console.log("Check values : "+country.countryCode+" / "+country.incomeLevel);

    return this.http.get("//localhost:8080/countries/"
    + country.countryCode + "?regionCheck="
    + country.region + "&incomelevelCheck="
    + country.incomeLevel + "&lendingtypeCheck="
    + country.lendingType)
  }
}

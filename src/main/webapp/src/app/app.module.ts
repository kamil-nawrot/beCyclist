import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatMomentDateModule, MomentDateAdapter, MomentDateModule} from '@angular/material-moment-adapter';
import {MatButtonModule} from '@angular/material/button';

import {SearchFormComponent} from './components/search-form/search-form.component';
import {ResultsGridComponent} from './components/results-grid/results-grid.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {HeaderComponent} from './components/header/header.component';
import {MainMenuComponent} from './components/main-menu/main-menu.component';
import {MatChipsModule} from '@angular/material/chips';

const appRoutes: Routes = [
  {path: 'search', component: SearchFormComponent},
  {path: 'results', component: ResultsGridComponent},
  {path: '', redirectTo: '/search', pathMatch: 'full'}
];

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    SearchFormComponent,
    ResultsGridComponent,
    HeaderComponent,
    MainMenuComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes, {enableTracing: false}
    ),
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatMomentDateModule,
    MatButtonModule,
    HttpClientModule,
    MomentDateModule,
    MatMomentDateModule,
    MatGridListModule,
    MatCardModule,
    MatChipsModule,
  ],
  providers: [MomentDateAdapter],
  bootstrap: [AppComponent]
})
export class AppModule {
}
